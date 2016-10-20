import cv2 
import numpy as np 
from skimage.measure import structural_similarity as ssim
import picamera
import warnings
from matplotlib import pyplot as plot 

#take a picture with the camera
camera = picamera.Picamera()
camera.capture('test.jpg')

#ignores warning given by ssim it isnt a fatal error
warnings.filterwarnings("ignore")

#read the images 
img = cv2.imread('test.jpg', 0)
template = [cv2.imread('test7.png', 0),cv2.imread('test6.png', 0)] #templates to look for

for i in range (0,2):

	#get width and height of temlpate 
	w, h = template[i].shape[::-1]

	#image processing 
	res = cv2.matchTemplate(img, template[i], 4)
	min_val, max_val, min_loc, max_loc = cv2.minMaxLoc(res)

	#box coordinates 
	top_left = max_loc
	bottom_right = (top_left[0] + w, top_left[1] + h)

	#draw a boc 
	cv2.rectangle(img, top_left, bottom_right, 255, 5)

	#crop initial image to create a image similar to the template
	crop_img = img[top_left[1]:top_left[1] + h, top_left[0]:top_left[0] + w]

	#same code as above just changed to test template against crop
	template2 = crop_img	 
	w2,h2 = template2.shape[::-1]

	res2 = cv2.matchTemplate(template[i], template2, 4)
	min_val2, max_val2, min_loc2, max_loc2 = cv2.minMaxLoc(res2)

	top_left2 = max_loc2
	bottom_right2 = (top_left2[0] + w2, top_left2[1] + h2)

	cv2.rectangle(template[i], top_left2, bottom_right2, 255, 5)

	#plots the image with the template found (uncomment to use)
	plot.imshow(img)
	plot.xticks([]), plot.yticks([])
	plot.show()

	#test similarity 

	similarity = ssim(crop_img, template[i])

	#if the similarity is above 82 then return stop number
	if similarity * 100 >= 85:
		similar = True
	else:
		similar = False

	if location == True and template[i].all() == template[0].all():
		print("similarity = " + str(similarity))	
	elif location == True and template[i].all() == template[1].all(): 
		print("similarity = " + str(similarity))
