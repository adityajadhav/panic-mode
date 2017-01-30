#!/usr/bin/env python
import web
import clarifai
import sys
from io import StringIO
from clarifai.rest import Image as ClImage
from clarifai.rest import ClarifaiApp
import requests
import os
import json

url='https://fcm.google.apis.com/fcm/send'

app = ClarifaiApp()
app.auth.get_token()
model = app.models.get('general-v1.3')

urls = (
    '/getTags', 'getClarifaiTags',
)

app = web.application(urls, globals())

def post():
        url='https://fcm.googleapis.com/fcm/send'
        myheaders={'Content-Type':'application/json', 
                   'Authorization':'key=SERVER_KEY'}
        payload={
            "to": "/topics/allDevices",
              "notification": {
                "body" : "greate match!",
                "title" : "You vs Me"
              }
        }
        response = requests.post(url,data=json.dumps(payload), headers=myheaders)

class getClarifaiTags:        
    def GET(self):
        os.system("wget 10.105.94.11:8080/shot.jpg");
        image = ClImage(file_obj=open('/home/root/rest_service/shot.jpg', 'rb'))
        results = model.predict([image])
        setofprediction = results['outputs'][0]['data']['concepts']
        for i in setofprediction:
              if (i['name'] == 'stress' || i['name'] == 'panic'):
                 post(); 
        os.system("rm -rf shot.jpg");
        return "Works"

if __name__ == "__main__":
    app.run()


#// LEverage the tries and tested methods that already exist
