import java.io.*;

class NetworkStabilityAnalyzer {
    // ANSI colors
    static final String RESET = "\u001B[0m", RED = "\u001B[31m", GREEN = "\u001B[32m", 
                         YELLOW = "\u001B[33m", BLUE = "\u001B[34m";
    static int getSignalPercent() {
        try {
            Process p = new ProcessBuilder("cmd.exe", "/c", "netsh wlan show interfaces").start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            for (String l; (l = r.readLine()) != null;)
                if (l.trim().startsWith("Signal"))
                    return Integer.parseInt(l.replaceAll("[^0-9]", ""));
        } catch (Exception e) {}
        return -1;
    }
    static int map(int dBm) {
        return dBm > -70 ? 1 : (dBm > -90 ? 0 : -1);
    }
    public static void main(String[] args) throws Exception {
        int[][] A = new int[3][3], raw = new int[3][3];
        System.out.println(GREEN + "\n1. Collecting the input signals" + RESET);
        System.out.println("\tReadings(%)\tSignals(dBm)");
        for (int k = 0; k < 9; k++) {
            int p = getSignalPercent(), d = (p >= 0 ? p / 2 - 100 : -100), c = map(d);
            raw[k / 3][k % 3] = d;  A[k / 3][k % 3] = c;
            System.out.printf("%d.\t" + RED + "%d" + RESET + "\t\t" + BLUE + "%d" + RESET + "%n", k + 1, p, d);
            Thread.sleep(1000);
        }
        System.out.println(GREEN + "\n2. Arranging data into 3x3 Matrix\n" + RESET);
        for (int i = 0; i < 3; i++) {
            System.out.print((i == 1 ? "A = " : "    ") + "[");
            for (int j = 0; j < 3; j++)
                System.out.print(BLUE + raw[i][j] + RESET + (j < 2 ? ", " : ""));
            System.out.println("]");
        }
        System.out.println(GREEN + "\nConverting the dBm signals...\n" + RESET);
        for (int[] row : A) {
            System.out.print("[");
            for (int j = 0; j < 3; j++)
                System.out.print(BLUE + row[j] + RESET + (j < 2 ? ", " : ""));
            System.out.println("]");
        }
        System.out.println(GREEN + "\n3. Compute Summations" + RESET);
        System.out.println("Calculating for rows");
        int[] alpha = new int[3], beta = new int[3];
        for (int i = 0; i < 3; i++) {
            alpha[i] = A[i][0] + A[i][1] + A[i][2];
            System.out.println(YELLOW + "Row " + (i + 1) + RESET + " = " + BLUE + alpha[i] + RESET);
        }
        System.out.println("\n" + YELLOW + "Row α" + RESET + " = [" + BLUE + alpha[0] + RESET + ", " + BLUE + alpha[1] + RESET + ", " + BLUE + alpha[2] + RESET + "]");
        System.out.println("\nCalculating for columns");
        for (int j = 0; j < 3; j++) {
            beta[j] = A[0][j] + A[1][j] + A[2][j];
            System.out.println(YELLOW + "Column " + (j + 1) + RESET + " = " + BLUE + beta[j] + RESET);
        }
        System.out.println("\n" + YELLOW + "Column β" + RESET + " = [" + BLUE + beta[0] + RESET + ", " + BLUE + beta[1] + RESET + ", " + BLUE + beta[2] + RESET + "]");
        int γ = A[0][0] + A[1][1] + A[2][2], δ = A[0][2] + A[1][1] + A[2][0];
        System.out.println("\nCalculating for diagonals");
        System.out.println(YELLOW + "Diagonal 1 (γ)" + RESET + " = " + BLUE + γ + RESET);
        System.out.println(YELLOW + "Diagonal 2 (δ)" + RESET + " = " + BLUE + δ + RESET);
        double F = (alpha[0] + alpha[1] + alpha[2] + beta[0] + beta[1] + beta[2] + γ + δ) / 8.0;
        System.out.println(GREEN + "\n4. Summation for Rows, Columns and Diagonals" + RESET);
        System.out.printf("f(A) = " + BLUE + "%.3f" + RESET + "%n", F);
        String result = (F >= 1.5) ? GREEN + "Good connection" + RESET :
                        (F <= -1.5) ? RED + "Weak connection" + RESET :
                        BLUE + "Moderate connection" + RESET;
        System.out.println();
        System.out.println(GREEN + "5. R(A)" + RESET + " -> " + GREEN + result + RESET);
    }
}
