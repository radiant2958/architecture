class Singleton:
    _instance = None

    def __new__(cls):
        if cls._instance is None:
            cls._instance = super(Singleton, cls).__new__(cls)
            cls._instance.is_resource_available = True
        return cls._instance

    def is_resource_available(self):
        return self.is_resource_available

    def set_resource_availability(self, availability):
        self.is_resource_available = availability



singleton_instance = Singleton()

print("Ресурс доступен:", singleton_instance.is_resource_available)

singleton_instance.set_resource_availability(False)

print("Ресурс доступен после изменения:", singleton_instance.is_resource_available)
