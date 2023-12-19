from django.shortcuts import render

def index(request):
    return render(request, 'myapp/index.html')

def services(request):
    return render(request, 'myapp/services.html')

def about_us(request):
    return render(request, 'myapp/about_us.html')

def contact(request):
    return render(request, 'myapp/contact.html')