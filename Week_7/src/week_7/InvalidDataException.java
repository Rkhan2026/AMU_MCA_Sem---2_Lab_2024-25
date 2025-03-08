package week_7;

class InvalidDataException extends Exception {
    InvalidDataException(String message) {
        //super(message) allows retrieval of the error message using getMessage()
        //like teh one I used in main method switch case 2.
        
        //If you don’t call super(message) then the error message won’t be 
        //stored in the parent Exception class, and calling getMessage() will return null.
        super(message);
    }
}
