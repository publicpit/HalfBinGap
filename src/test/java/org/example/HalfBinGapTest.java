package org.example;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class HalfBinGapTest {

  HalfBinGap halfBinGap;
  private Object IllegalArgumentException;

  @BeforeEach
  void init() {
    halfBinGap = new HalfBinGap();
  }

  @Test
  @Disabled
  void testDisabled() {
    fail("This test should be disabled");
  }

  @Test
  void makeBinaryNumberContainer() {
    assertEquals(2, halfBinGap.makeBinaryNumberContainer(2), 0);
    assertEquals(3, halfBinGap.makeBinaryNumberContainer(4), 0);
    assertEquals(4, halfBinGap.makeBinaryNumberContainer(15), 0);
    assertEquals(5, halfBinGap.makeBinaryNumberContainer(16), 0);
    assertEquals(9, halfBinGap.makeBinaryNumberContainer(256), 0);
    assertEquals(16, halfBinGap.makeBinaryNumberContainer(65535), 0);
    assertEquals(64, halfBinGap.makeBinaryNumberContainer(Long.MAX_VALUE));
    assertThrows(IllegalArgumentException.class, () -> halfBinGap.makeBinaryNumberContainer(-10));
//    assertThrows(
//        IllegalArgumentException.class,
//        () -> halfBinGap.makeBinaryNumberContainer(Long.MAX_VALUE + 1));
  }

  @Test
  void convertBinary() {
    assertArrayEquals(new int[] {1, 0, 0}, halfBinGap.convertBinary(4));
    assertArrayEquals(new int[] {1, 0, 0, 0}, halfBinGap.convertBinary(8));
    assertArrayEquals(new int[] {1, 0, 0, 0, 0, 0, 0, 0, 0}, halfBinGap.convertBinary(256));
  }

  @Test
  void getBinaryGap() {
    assertEquals(2, halfBinGap.getBinaryGap(9));
    assertEquals(9, halfBinGap.getBinaryGap(67236083));
    assertEquals(12, halfBinGap.getBinaryGap(99614963));
    assertEquals(21, halfBinGap.getBinaryGap(51002736883L));
    assertEquals(61, halfBinGap.getBinaryGap(0b100000000000000000000000000000000000000000000000000000000000001L));
    assertEquals(0, halfBinGap.getBinaryGap(Long.MAX_VALUE));
    assertEquals(13, halfBinGap.getBinaryGap(0b10000001100000000110000000001000000000011100000000000001L));


  }
}
