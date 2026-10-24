# Contact Management App

## Project Overview

The Contact Management App is a Java console-based application developed as part of the CodeNova Java Programming Internship. It helps users manage contact information through a simple menu-driven interface.

## Features

- Add new contacts
- View all saved contacts
- Search contacts by name or phone number
- Edit existing contacts
- Delete contacts
- Validate email addresses
- Validate phone numbers to ensure they contain exactly 10 digits
- Prevent duplicate phone numbers
- Save contacts to a local file using Java serialization
- Retain saved contacts after restarting the application

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Java Collections Framework (`ArrayList`)
- Java Serialization
- VS Code

## Project Structure

```text
ContactManagementApp/
├── src/
│   ├── Main.java
│   ├── model/
│   │   └── Contact.java
│   ├── repository/
│   │   └── ContactRepository.java
│   ├── service/
│   │   └── ContactService.java
│   └── ui/
│       └── ContactApp.java
├── README.md
└── contacts.dat (created when contacts are saved)
```

## How to Run

### Prerequisites

Install the Java Development Kit (JDK) and Visual Studio Code with the Java extensions.

### Compile

Open the terminal in the `ContactManagementApp` folder and run:

```bash
javac -d out src/Main.java src/model/Contact.java src/repository/ContactRepository.java src/service/ContactService.java src/ui/ContactApp.java
```

### Execute

Run:

```bash
java -cp out Main
```

## How to Use

1. Select **1** to add a contact.
2. Select **2** to view all contacts.
3. Select **3** to search by name or phone number.
4. Select **4** to edit a contact using its current phone number.
5. Select **5** to delete a contact using its phone number.
6. Select **6** to exit the application.

## Data Storage

Contact information is stored locally in `contacts.dat` using Java object serialization. The file is created when a contact is saved and is used to load contacts on subsequent runs.

## Testing Performed

- Added a contact successfully.
- Viewed saved contacts.
- Searched for a contact.
- Edited a contact.
- Deleted a contact.
- Restarted the application and verified saved data.
- Tested rejection of an invalid phone number.
- Tested rejection of an invalid email address.

## Author

CodeNova Java Programming Internship Participant
