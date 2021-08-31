

public class main{
    static float calculateTotTime(float time, float sessionDuration) {
        float totTime = time + sessionDuration;
        return totTime;
    }

    static float roundOffValue(float time) {
        time = Math.round(time * 100.00f) / 100.00f;
        return time;
    }

    static float minToHour(float time) {
        float currMinute = 0;
        currMinute = time % 1;
        if (currMinute > 0.60f) {
            time = (time - 0.60f) + 1.00f;
        }
        return time;
    }

    static Conf[] initializeArray(Conf[] session) {
        session[0] = new Conf(60, "Writing Fast Tests Against Enterprise Rails 60min");
        session[1] = new Conf(45, "Overdoing it in Python 45min");
        session[2] = new Conf(30, "Lua for the Masses 30min");
        session[3] = new Conf(45, "Ruby Errors from Mismatched Gem Versions 45min");
        session[4] = new Conf(60, "Ruby on Rails: Why We Should Move On 60min");
        session[5] = new Conf(45, "Common Ruby Errors 45min");
        session[6] = new Conf(45, "Pair Programming vs Noise 45min");
        session[7] = new Conf(30, "Programming in the Boondocks of Seattle 30min");
        session[8] = new Conf(30, "Ruby vs. Clojure for Back-End Development 30min");
        session[9] = new Conf(30, "Sit Down and Write 30min");
        session[10] = new Conf(60, "Rails Magic 60min");
        session[11] = new Conf(60, "Rails for Python Developers lightning Communicating Over Distance 60min");
        session[12] = new Conf(30, "Woah 30min");
        session[13] = new Conf(45, "Accounting-Driven Development 45min");
        session[14] = new Conf(45, "Clojure Ate Scala (on my project) 45min");
        session[15] = new Conf(60, "Ruby on Rails Legacy App Maintenance 60min");
        session[16] = new Conf(30, "A World Without HackerNews 30min");
        session[17] = new Conf(30, "User Interface CSS in Rails Apps 30min");
        return session;
    }

    public static void main(String []args) {
        Conf[] session;
        session = new Conf[18];
        session = initializeArray(session);

        float time = 9.00f;
        float totTime = 9.00f;
        boolean lunchDone = false;
        boolean isLunchTime = false;

        System.out.println("Track 1");
        for (int i = 0; i < session.length; i++) {
            float sessionDuration;
            if (!lunchDone && totTime >= 12) {
                i--;
                sessionDuration = 1.00f;
                isLunchTime = true;
                time = 12.00f;
            } else {
                if (session[i].duration == 60) {
                    sessionDuration = 1.00f;
                } else {
                    sessionDuration = session[i].duration / 100;
                }
            }
            totTime = calculateTotTime(time, sessionDuration);

            // Round off values
            totTime = roundOffValue(totTime);
            time = roundOffValue(time);
            
            totTime = minToHour(totTime);
            
            // reset all values for second day
            if (totTime >= 17 && i == 9) {
                System.out.println("17:00PM Networking");
                System.out.println("");
                System.out.println("Track 2");

                time = 9.0f;
                totTime = 9.0f + sessionDuration;
                lunchDone = false;
                isLunchTime = false;
            }

            if (isLunchTime && !lunchDone) {
                System.out.println(time + "PM" + " " + "Lunch");
                lunchDone = true;
            } else
                session[i].printSession(time);
            time = totTime;
            if (time >= 16 && i == 16) {
                System.out.println("16.00PM Networking");
                time = totTime + 1.00f;
            }
        }
    }

    public static class Conf{
        public float duration;
        public String topic;
    
        Conf(float duration, String topic){
            this.duration = duration;
            this.topic = topic;
        }
        public void printSession(float time){
        if (time < 12) {
            System.out.println(time + "AM" + " " + topic);
        } else
            if (time >= 12) {
                System.out.println(time + "PM" + " " + topic);
            }
        }
    }
}
