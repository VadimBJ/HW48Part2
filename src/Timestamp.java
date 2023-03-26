public class Timestamp implements Comparable<Timestamp> {
  private long minutes;
  private int timeH;
  private int timeM;

  public Timestamp(String time) {
    parseTime(time);
  }

  private void parseTime(String time) {
    String[] param = time.split(":");
    if (param.length > 2) {
      throw new IllegalArgumentException("Некорректные входные данные!");
    }
    timeH = Integer.parseInt(param[0]);
    timeM = Integer.parseInt(param[1]);
    if (timeH < 0 || timeH > 23 || timeM < 0 || timeM > 59) {
      throw new IllegalArgumentException("Некорректные входные данные!");
    }
    minutes = timeH * 60 + timeM;
  }

  private void parseFromMinutes(long minutes) {
    timeH = (int) (minutes / 60);
    if (timeH > 23) {
      timeH %= 24;
    }
    timeM = (int) (minutes % 60);
  }

  public void increaseOnMinutes(int diffMinutes) {
    minutes += diffMinutes;
    parseFromMinutes(minutes);
  }

  public void increaseOnHour(int diffHour) {
    minutes += (int) (diffHour * 60);
    parseFromMinutes(minutes);
  }

  @Override
  public String toString() {
    String timeMin = "00" + timeM;
    return timeH + ":" + timeMin.substring(timeMin.length() - 2);
  }

  @Override
  public int compareTo(Timestamp obj) {
    if (timeH == obj.timeH) {
      return timeM-obj.timeM;
    }
    return timeH-obj.timeH;
  }
}
