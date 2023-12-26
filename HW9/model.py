from datetime import datetime

class WeatherForecast:
    def __init__(self, date, temperature_c):
        self.date = date
        self.temperature_c = temperature_c

    @property
    def temperature_f(self):
        return 32 + int(self.temperature_c / 0.5556)


class WeatherForecastHolder:
    def __init__(self):
        self._values = []

    def add(self, date, temperature_c):
        weather_forecast = WeatherForecast(date, temperature_c)
        self._values.append(weather_forecast)

    def get(self, date_from, date_to):
        return [wf for wf in self._values if date_from <= wf.date <= date_to]

    def update(self, date, temperature_c):
        for item in self._values:
            if item.date == date:
                item.temperature_c = temperature_c
                return True
        return False

    def delete(self, date):
        original_count = len(self._values)
        self._values = [wf for wf in self._values if wf.date != date]
        return original_count != len(self._values)