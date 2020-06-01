package org.example;

public class HalfBinGap {

  public int makeBinaryNumberContainer(long n) {
    if (n < 0) {
      throw new IllegalArgumentException(
          "Illegal number: should be greater or equal to zero and lesser than 9223372036854775807\u202C ");
    }
    return (int) (Math.log(n) / Math.log(2)) + 1; // number of bits
  }

  public int[] convertBinary(long n) {
    int i = makeBinaryNumberContainer(n);
    int[] myBinary = new int[i];
    for (int j = 1; j <= i; j++) {
      myBinary[i - j] = (int) n % 2;
      n /= 2;
    }
    return myBinary;
  }

  public int getBinaryGap(long n) {
    int[] myBinary = convertBinary(n);
    int[] myCounts = new int[makeBinaryNumberContainer(n)];
    int pass = 0;
    int stepGaps = 0;

    for (int i = 0; i < makeBinaryNumberContainer(n); i++) {
      if (myBinary[i] == 1) {
        pass++;
        myCounts[pass - 1] = stepGaps; // save the various gaps in an array
        stepGaps = 0;
      } else if (pass > 0) {
        stepGaps++;
      }
    }

    for (int i = 0; i < pass; i++) {
      if (myCounts[i] > myCounts[i + 1]) {
        myCounts[i + 1] = myCounts[i];
      }
    }
    return myCounts[pass];
  }
}
