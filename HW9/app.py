from datetime import datetime
from flask import Flask, request, jsonify

from model import WeatherForecastHolder
from sql_weather_forecast_repository import SqlWeatherForecastRepository

app = Flask(__name__)
repository = SqlWeatherForecastRepository("path_to_your_sqlite.db")
weather_forecast_holder = WeatherForecastHolder(repository)

@app.route('/')
def home():
    return 'Welcome to the Weather Forecast API!'

@app.route('/api/add', methods=['POST'])
def add():
    date = datetime.strptime(request.args.get('date'), '%Y-%m-%d')
    temperature_c = int(request.args.get('temperatureC'))
    weather_forecast_holder.add(date, temperature_c)
    return 'Added', 200

@app.route('/api/update', methods=['PUT'])
def update():
    date = datetime.strptime(request.args.get('date'), '%Y-%m-%d')
    temperature_c = int(request.args.get('temperatureC'))
    result = weather_forecast_holder.update(date, temperature_c)
    if result:
        return jsonify({'result': 'success'}), 200
    else:
        return jsonify({'result': 'failure', 'reason': 'not found'}), 404

@app.route('/api/get-all', methods=['GET'])
def get_all():
    date_from = datetime.strptime(request.args.get('dateFrom'), '%Y-%m-%d')
    date_to = datetime.strptime(request.args.get('dateTo'), '%Y-%m-%d')
    forecasts = weather_forecast_holder.get(date_from, date_to)
    return jsonify([{'date': wf.date, 'temperatureC': wf.temperature_c, 'temperatureF': wf.temperature_f} for wf in forecasts])

@app.route('/api/delete', methods=['DELETE'])
def delete():
    date = datetime.strptime(request.args.get('date'), '%Y-%m-%d')
    result = weather_forecast_holder.delete(date)
    if result:
        return jsonify({'result': 'success'}), 200
    else:
        return jsonify({'result': 'failure', 'reason': 'not found'}), 404

if __name__ == '__main__':
    app.run(debug=True)
