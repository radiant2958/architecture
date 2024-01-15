import unittest
import app  
import json

class FlaskAppTests(unittest.TestCase):

    def setUp(self):
        self.app = app.app.test_client()
        self.app.testing = True
       

    def test_add_forecast(self):
        response = self.app.post('/api/add', data=json.dumps({'date': '2022-10-10', 'temperatureC': 20}),
                                 content_type='application/json')
        self.assertEqual(response.status_code, 200)
        self.assertIn('Added', response.data.decode())

    def test_update_forecast(self):
        response = self.app.put('/api/update', data=json.dumps({'date': '2022-10-10', 'temperatureC': 25}),
                                content_type='application/json')
        self.assertEqual(response.status_code, 200)
        self.assertIn('success', response.data.decode())


    def test_delete_forecast(self):
        self.app.post('/api/add', data=json.dumps({'date': '2022-10-10', 'temperatureC': 20}),
                  content_type='application/json')
    
        response = self.app.delete('/api/delete', data=json.dumps({'date': '2022-10-10'}),
                                content_type='application/json')
        self.assertEqual(response.status_code, 200)
        self.assertIn('success', response.data.decode())


if __name__ == 'main':
    unittest.main()