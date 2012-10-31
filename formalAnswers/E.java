
import java.util.*;

public class E {
  public static Scanner in;
  public static int caseNum;
  public static int n, q, v;
  public static int w[], m[];
  public static long[][] t;
  public static long[][] binom;
  public static long[] bpi;
  public static long bpitotal;

  public static void main(String[] args) {
    in = new Scanner(System.in);
    caseNum = 0;

    // We will sometimes need to count # of ways to choose j people
    // from a group of i people, where i <= 60, so why not just
    // compute all these values once and for all and save them?
    binom = new long[61][61];
    binom[0][0] = 1;
    for (int i = 1; i <= 60; i++) {
// NOTE: no value, or sum of values, in any row of this table can
// exceed 2^60, so will fit in a "long"
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i)
          binom[i][j] = 1;
        else
          binom[i][j] = binom[i-1][j-1] + binom[i-1][j];
      }
    }

    // Main processing loop:
    while (true) {
      n = in.nextInt();
      if (n == 0) 
        break;
      caseNum++;

      // input checking
      if (n < 1 || n > 60)
        System.out.println("#!#!#!#! illegal n in case " + caseNum + ": "+n);

      q = in.nextInt();
      w = new int[n];
      m = new int[n];
      v = 0;
      for (int i = 0; i < n; i++) {
        w[i] = in.nextInt();
        m[i] = in.nextInt();
        // input checking
        if (w[i] <= 0 || w[i] > 60)
          System.out.println("#!#!#!#! illegal weight in case " + 
                             caseNum + ": w[" +i+"] = "+w[i]);
        if (m[i] <= 0 || m[i] > 60)
          System.out.println("#!#!#!#! illegal m value in case " + 
                              caseNum + ": m[" +i+"] = "+m[i]);
        v += w[i]*m[i];
      }
      // input checking--make sure no two weights are equal
      for (int i = 0; i < n-1; i++) {
        for (int j = i+1; j < n; j++)
          if (w[i] == w[j]) {
            System.out.println("#!#!#!#! duplicate weight in case " + 
                               caseNum + ": " + w[i]);
            break;
        }
      }
      // input checking
      if (v > 60)
        System.out.println("#!#!#!#! illegal V in case " + caseNum + ": "+v);

      process();
    }
  }

  public static void process() {

    bpitotal = 0;
    bpi = new long[n];
    Arrays.fill(bpi,0);
    for (int i = 0; i < n; i++) {
      // calculate # winning coalitions for member of weight w[i]
      t = new long[n][q]; // dyn prog table
      m[i]--; // use ONE vote of weight w[i]
      // ...
      for (int row = 0; row < n; row++)
        t[row][0] = 1;
      for (int j = 1; j <= m[0] && j*w[0] <= q-1; j++)
        t[0][j*w[0]] = binom[m[0]][j];

      for (int col = 1; col < q; col++) {
        for (int row = 1; row < n; row++) {
          t[row][col] = t[row-1][col];
          for(int j = 1; j <= m[row] && col-j*w[row] >= 0; j++) {
            t[row][col] += binom[m[row]][j]*t[row-1][col-j*w[row]];
          }
        }
      }

      for (int j = Math.max(q-w[i],0); j <= q-1; j++)
        bpi[i] += t[n-1][j];

      m[i]++; // restore the one used vote
      bpitotal += bpi[i]*m[i];
    }
    System.out.print("Case " + caseNum + ": ");
    for (int i = 0; i < n; i++) {
      System.out.print(bpi[i]);
      if (i < n-1) System.out.print(" ");
    }
    System.out.println();
  }
}
