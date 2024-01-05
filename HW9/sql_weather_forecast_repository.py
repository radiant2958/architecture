from IWeatherForecastRepository import IWeatherForecastRepository
import sqlite3
from datetime import datetime

from model import WeatherForecast

class SqlWeatherForecastRepository(IWeatherForecastRepository):

    def __init__(self, db_path):
        self.db_path = db_path

    def _connect(self):
        return sqlite3.connect(self.db_path)

    def add(self, weather_forecast):
        conn = self._connect()
        cursor = conn.cursor()
        cursor.execute("INSERT INTO weather_forecasts (date, temperature_c) VALUES (?, ?)",
                       (weather_forecast.date.strftime('%Y-%m-%d'), weather_forecast.temperature_c))
        conn.commit()
        conn.close()

    def get(self, date_from, date_to):
        conn = self._connect()
        cursor = conn.cursor()
        cursor.execute("SELECT date, temperature_c FROM weather_forecasts WHERE date BETWEEN ? AND ?",
                       (date_from.strftime('%Y-%m-%d'), date_to.strftime('%Y-%m-%d')))
        forecasts = [WeatherForecast(datetime.strptime(row[0], '%Y-%m-%d'), row[1]) for row in cursor.fetchall()]
        conn.close()
        return forecasts

    def update(self, date, temperature_c):
        conn = self._connect()
        cursor = conn.cursor()
        cursor.execute("UPDATE weather_forecasts SET temperature_c = ? WHERE date = ?",
                       (temperature_c, date.strftime('%Y-%m-%d')))
        updated = cursor.rowcount
        conn.commit()
        conn.close()
        return updated > 0

    def delete(self, date):
        conn = self._connect()
        cursor = conn.cursor()
        cursor.execute("DELETE FROM weather_forecasts WHERE date = ?",
                       (date.strftime('%Y-%m-%d'),))
        deleted = cursor.rowcount
        conn.commit()
        conn.close()
        return deleted > 0