PROJECT TITLE: Vending Machine
PURPOSE OF PROJECT: Virtual Vending Machine Simulation
VERSION or DATE: 03/08/24
HOW TO START THIS PROJECT: Launch the .java files and once launched head to the Main class and select 
the Run 'Main.java' button near the top right of the program or alternatively press 'Shift+F10' to 
launch the program.
AUTHORS: Garrett J Engelder

USER INSTRUCTIONS: Once the program is running the user is either to input a cash amount into the vending 
machine or to log in using their face hash ID to begin the vending process. 
If an amount of cash has been inputted into the vending machine it will be checked using validation checks and processed accordingly. 
If the user logged in using their face hash ID their balance in the MYSQL database will be sent to the vending machine and processed accordingly.
Once the vending machine has received funding, the user will then select a product from the sending machine using slot IDs.
If the slot ID is invalid or out of stock the user will be asked to select a different slot.
If the slot is valid, the user is logged in, and the user does not have enough funding, they will be asked to select a different slot.
If the slot is valid, the user is not logged in, and the user does not have enough funding, they will be asked to select a different slot OR insert cash.
If the slot id valid and the user has enough funding then the vending machine will dispense the product and the user will receive their change according
to the way that they had paid.
From here the program will return to the start and ask the user to input a cash amount into the vending 
machine or to log in using their face hash ID to begin the vending process once more.

To edit MYSQL database connection url/user/password first make sure you have launched all program 
related .java files and head to the DataConnect class. Once in the DataConnect class you should see three
local variables labeled; "url", "user", and "pass". you can enter the jdbc connection to your MYSQL database
in the "url" variable data location. The username associated with the MYSQL database will be entered in 
the "user" varaible data location. Finally the password associated with the MYSQL database will be 
entered in the "pass" variable data location.