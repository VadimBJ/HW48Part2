import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TimestampTests {
  @Test
  public void negativeHour() {
    assertThrowsExactly(IllegalArgumentException.class, () -> new Timestamp("-23:15"));
  }

  @Test
  public void negativeMinutes() {
    assertThrowsExactly(IllegalArgumentException.class, () -> new Timestamp("23:-15"));
  }

  @Test
  public void negativeAll() {
    assertThrowsExactly(IllegalArgumentException.class, () -> new Timestamp("-53:-15"));
  }

  @Test
  public void wrongHour() {
    assertThrowsExactly(IllegalArgumentException.class, () -> new Timestamp("53:15"));
  }

  @Test
  public void wrongMinutes() {
    assertThrowsExactly(IllegalArgumentException.class, () -> new Timestamp("23:75"));
  }

  @Test
  public void wrongAll() {
    assertThrowsExactly(IllegalArgumentException.class, () -> new Timestamp("63:85"));
  }

  @Test
  public void wrongString() {
    assertThrowsExactly(IllegalArgumentException.class, () -> new Timestamp("23:15:23"));
  }

  @Test
  public void emptyString() {
    assertThrowsExactly(IllegalArgumentException.class, () -> new Timestamp(""));
  }

  @Test
  public void constructorTest() {
    Timestamp timestamp = new Timestamp("23:15");
    assertEquals(23, timestamp.getTimeH());
    assertEquals(15, timestamp.getTimeM());
  }

  @Test
  public void sortTest() {
    Timestamp timestamp1 = new Timestamp("23:15");
    Timestamp timestamp2 = new Timestamp("13:15");
    int result = timestamp1.compareTo(timestamp2);
    assertTrue(result > 0);
  }
}
