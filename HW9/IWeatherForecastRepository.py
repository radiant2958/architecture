from abc import ABC, abstractmethod

class IWeatherForecastRepository(ABC):

    @abstractmethod
    def add(self, weather_forecast):
        pass

    @abstractmethod
    def get(self, date_from, date_to):
        pass

    @abstractmethod
    def update(self, date, temperature_c):
        pass

    @abstractmethod
    def delete(self, date):
        pass
