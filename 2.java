import java.util.*;
class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a line of code:");
		String input = scanner.nextLine();
		scanner.close();
		Set<String> keywords = new HashSet<>(Arrays.asList("int", "float", "if", "else", "while", "return"));
		StringTokenizer tokenizer = new StringTokenizer(input, " (){}[];,=+-*/<>&", true);
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken().trim();
			if (token.isEmpty()) continue;
			if (keywords.contains(token)) {
				System.out.println(token + " : KEYWORD");
			} else if (token.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
				System.out.println(token + " : IDENTIFIER");
			} else if (token.matches("\\d+")) {
				System.out.println(token + " : NUMBER");
			} else if ("(){}[];,=+-*/<>&".contains(token)) {
				System.out.println(token + " : SYMBOL");
			} else {
				System.out.println(token + " : UNKNOWN");
			}
		}
	}
}