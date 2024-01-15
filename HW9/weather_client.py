import requests

BASE_URL = "http://127.0.0.1:5000/api"  

def add_forecast(date, temperature_c):
    response = requests.post(f"{BASE_URL}/add", json={'date': date, 'temperatureC': temperature_c})
    return response.text

def update_forecast(date, temperature_c):
    response = requests.put(f"{BASE_URL}/update", json={'date': date, 'temperatureC': temperature_c})
    if response.status_code == 200:
        return response.json()
    else:
        return response.text


def get_all_forecasts(date_from, date_to):
    response = requests.get(f"{BASE_URL}/get-all", params={'dateFrom': date_from, 'dateTo': date_to})
    if response.status_code == 200:
        return response.json()
    else:
        return [] 
    
    
def delete_forecast(date):
    response = requests.delete(f"{BASE_URL}/delete", json={'date': date})
    return response.json()


def main():
    while True:
        print("\nWeather Forecast Client")
        print("1. Add Forecast")
        print("2. Update Forecast")
        print("3. Get All Forecasts")
        print("4. Delete Forecast")
        print("5. Exit")
        choice = input("Enter your choice: ")

        if choice == '1':
            date = input("Enter date (YYYY-MM-DD): ")
            temp = input("Enter temperature (Celsius): ")
            print(add_forecast(date, temp))
        elif choice == '2':
            date = input("Enter date (YYYY-MM-DD) for update: ")
            temp = input("Enter new temperature (Celsius): ")
            print(update_forecast(date, temp))
        elif choice == '3':
            date_from = input("Enter start date (YYYY-MM-DD): ")
            date_to = input("Enter end date (YYYY-MM-DD): ")
            forecasts = get_all_forecasts(date_from, date_to)
            for forecast in forecasts:
                print(f"{forecast['date']}: {forecast['temperatureC']}C ({forecast['temperatureF']}F)")
        elif choice == '4':
            date = input("Enter date (YYYY-MM-DD) to delete: ")
            print(delete_forecast(date))
        elif choice == '5':
            break
        else:
            print("Invalid choice. Please try again.")

if __name__ == "__main__":
    main()
