import java.util.Scanner;

public class EncryptionDecryptionProgram {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static String encrypt(String plaintext, int shift) {
        // Convert the plaintext to lowercase letters
        plaintext = plaintext.toLowerCase();

        // Create an empty string to store the encrypted message
        StringBuilder ciphertext = new StringBuilder();

        // Loop through each character in the plaintext
        for (int i = 0; i < plaintext.length(); i++) {
            // Get the current character
            char c = plaintext.charAt(i);

            // Find the position of the character in the alphabet
            int index = ALPHABET.indexOf(c);

            // If the character is in the alphabet
            if (index != -1) {
                // Calculate the new position by adding the shift value
                int newIndex = (index + shift) % 26;

                // Get the character at the new position
                char newChar = ALPHABET.charAt(newIndex);

                // Add the new character to the encrypted message
                ciphertext.append(newChar);
            } else {
                // If the character is not in the alphabet, just add it as it is
                ciphertext.append(c);
            }
        }

        // Return the encrypted message
        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext, int shift) {
        // Convert the ciphertext to lowercase letters
        ciphertext = ciphertext.toLowerCase();

        // Create an empty string to store the decrypted message
        StringBuilder plaintext = new StringBuilder();

        // Loop through each character in the ciphertext
        for (int i = 0; i < ciphertext.length(); i++) {
            // Get the current character
            char c = ciphertext.charAt(i);

            // Find the position of the character in the alphabet
            int index = ALPHABET.indexOf(c);

            // If the character is in the alphabet
            if (index != -1) {
                // Calculate the original position by subtracting the shift value
                // and adding 26 to handle negative values
                int newIndex = (index - shift + 26) % 26;

                // Get the character at the original position
                char newChar = ALPHABET.charAt(newIndex);

                // Add the original character to the decrypted message
                plaintext.append(newChar);
            } else {
                // If the character is not in the alphabet, just add it as it is
                plaintext.append(c);
            }
        }

        // Return the decrypted message
        return plaintext.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user if they want to encrypt or decrypt a message
        System.out.print("Do you want to encrypt or decrypt a message? (Enter 'e' for encrypt or 'd' for decrypt): ");
        String choice = scanner.nextLine();

        if (choice.equals("e")) {
            // If the user chooses to encrypt
            System.out.print("Enter a message to encrypt: ");
            String message = scanner.nextLine();

            System.out.print("Enter the shift value (Only Numbers, think if this as your pin): ");
            int shift = scanner.nextInt();

            // Call the encrypt method to encrypt the message
            String encryptedMessage = encrypt(message, shift);
            System.out.println("Encrypted message: " + encryptedMessage);
        } else if (choice.equals("d")) {
            // If the user chooses to decrypt
            System.out.print("Enter a message to decrypt: ");
            String message = scanner.nextLine();

            System.out.print("Enter the shift value (Only Numbers, think if this as your pin): ");
            int shift = scanner.nextInt();

            // Call the decrypt method to decrypt the message
            String decryptedMessage = decrypt(message, shift);
            System.out.println("Decrypted message: " + decryptedMessage);
        } else {
            // If the user enters an invalid choice
            System.out.println("Invalid choice. Please enter 'e' for encrypt or 'd' for decrypt.");
        }

        scanner.close();
    }
}