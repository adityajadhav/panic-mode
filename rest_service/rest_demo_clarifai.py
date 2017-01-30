#!/usr/bin/env python
import clarifai
import sys
from io import StringIO
from clarifai.rest import Image as ClImage
from clarifai.rest import ClarifaiApp
import requests
import os
import json

app = ClarifaiApp()
app.auth.get_token()
model = app.models.get('general-v1.3')

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

def detect():
        os.system("wget 10.105.94.11:8080/shot.jpg");
        image = ClImage(file_obj=open('/home/root/rest_service/shot.jpg', 'rb'))
        results = model.predict([image])
        os.system("rm -rf shot.jpg");
        setofprediction = results['outputs'][0]['data']['concepts']
        for i in setofprediction:
              print i['name']
              if (i['name']=="industry" or i['name']=="stress" or i['name'] is "injury" or i['name'] is "accident"):
                  post(); 
                  sys.exit(0)

if __name__ == "__main__":
    while 1:
        detect()

