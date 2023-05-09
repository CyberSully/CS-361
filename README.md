# CS-361 Instructions for micro-service requests and responds 
A.	Clear instructions for how to REQUEST data from the microservice you implemented. Include an example call.
For now the microservice is going to respond to a request by checking a file for a run command. Once the file is checked and the “run” is confirmed, the microservice will send data back to the program that is calling it. 
Example call: “FileWriter myWriter = new FileWriter("C:\\\\CS-361\\\\prng-service.txt\\");
myWriter.write("run"); //writes run command to prng.txt file
myWriter.close();
Thread.sleep(2000);
System.out.println("Successfully wrote run command to the prng.txt file.");
”
B.	Clear instructions for how to RECEIVE data from the microservice you implemented
As mentioned above, a simple run command is going to initiate the microservice to do its job. Once the microservice checks and has the command to run it will automatically send data back to the program that called it. 
![image](https://user-images.githubusercontent.com/93303949/236999655-67ac7b3e-cc0f-4e47-9657-922f48fabeca.png)
![image](https://user-images.githubusercontent.com/93303949/237000059-e4061995-6eac-4b81-b4b4-5fb00b0c8709.png)
As you can see in the flow chart, once the run command is processed, the program will write back with specific data requested. 
