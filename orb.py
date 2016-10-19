import numpy as np
import cv2
import time
import multiprocessing
import picamera
from joblib import Parallel, delayed

# start clock 
start_time = time.time()

#############################################################################

# function to implement SURF like algorithm to dectect matches in a scene to a template 

def image_pro(img, img2):

  # Initiate ORB detector
  orb = cv2.ORB()
   
  # compute the descriptors with ORB
  kp, des = orb.detectAndCompute(img, None)
  kp2, des2 = orb.detectAndCompute(img2,None)

  # create BFMatcher object
  bf = cv2.BFMatcher()
  
  # Match descriptors.
  matches = bf.knnMatch(des,des2, k = 2)

  # creates an array of matches 	
  good = []
  for m,n in matches:
      if m.distance < 0.75*n.distance:
          good.append(m)

  # gets length of the array created previously and returns the number of matches found for each picture
  match = len(good)
  return match

##############################################################################

# uses number of matches returned from first function to approximate distance and location. 

def distance(match):
  if max(match) >= 20 and max(match) == match[0]: 
      print("within 1 ft of marker 1")
  elif max(match) >= 20 and max(match) == match[1]:  
      print("within 1 ft of marker 2")
  elif max(match) >= 20 and max(match) == match[2]: 
      print("within 1 ft of marker 3")
  elif max(match) >= 20 and max(match) == match[3]: 
      print("within 1 ft of marker 4")
  elif max(match) < 20 and max(match) >= 15 and max(match) == match[0]: 
      print("within 3 ft of marker 1")
  elif max(match) < 20 and max(match) >= 15 and max(match) == match[1]:  
      print("within 3 ft of marker 2")
  elif max(match) < 20 and max(match) >= 15 and max(match) == match[2]: 
      print("within 3 ft of marker 3")
  elif max(match) < 20 and max(match) >= 15 and max(match) == match[3]: 
      print("within 3 ft of marker 4")

################################################################################

# camera code to take photograph that will be searched 
camera = picamera.PiCamera()
camera.capture('scene.jpg')

# img = the images to look for / img2 = scene to be searched 
img = [cv2.imread('1.png',1), cv2.imread('2.png',1), cv2.imread('3.png',1), cv2.imread('4.png',1)]
img2 = cv2.imread('scene.jpg')

# gets cpu core count for use in a later function 
cores = multiprocessing.cpu_count()

# input range 
inputs = range(len(img))

#runs loop in parallel on multiple cores to reduce computation time on raspberry pi
match = Parallel(n_jobs = cores, backend = 'threading' )(delayed(image_pro)(img[i], img2) for i in inputs)

# outputs "distance and approximate "location"
ouput = distance(match) 

# print statement to get program runtime | using this for optimization 
print("%s" % str((time,time.time() - start_time)))
