from datetime import datetime

class WeatherForecast:
    def __init__(self, date, temperature_c):
        self.date = date
        self.temperature_c = temperature_c

    @property
    def temperature_f(self):
        return 32 + int(self.temperature_c / 0.5556)


class WeatherForecastHolder:
    def __init__(self, repository):
        self.repository = repository

    def add(self, date, temperature_c):
        weather_forecast = WeatherForecast(date, temperature_c)
        self.repository.add(weather_forecast)

    def get(self, date_from, date_to):
        return self.repository.get(date_from, date_to)

    def update(self, date, temperature_c):
        return self.repository.update(date, temperature_c)

    def delete(self, date):
        return self.repository.delete(date)