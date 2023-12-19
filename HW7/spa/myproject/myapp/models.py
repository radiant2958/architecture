from django.db import models

class Client(models.Model):
    name = models.CharField('Имя', max_length=50)
    phone = models.CharField('Телефон', max_length=15)

    def __str__(self):
        return f"{self.name}, {self.phone}"