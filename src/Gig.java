public class Gig {

    private int attendance;

    //todo: gig sim, tour sim (x gigs), attendance picker

    public int getAttendance(Venue venue){
        int capacity = venue.getVenueCapacity();
        int attendance;
        int attendancePicker = (int) (Math.random() * 3);
        switch (attendancePicker){
            case 1 -> attendance = capacity/100 * 90;
            case 2 -> attendance = capacity/100 * 75;
            case 3 -> attendance = capacity/100 * 40;
            default -> attendance = capacity/100 * 25;
        }
        return attendance;
    }

    public void playGig(Venue venue, Band band){
        System.out.println(band.getBandName() + " plays at " + venue.getVenueName());
        int attendancePercent = getAttendance(venue) / (venue.getVenueCapacity()/100);
        System.out.println("Playing at " + venue);
        if (attendancePercent >= 80 && attendancePercent <= 100){
            System.out.println("Great turnout!\nAttendance: " + attendancePercent);
            System.out.println("Fans: " + band.getFans() + " -> " + (band.getFans() + 200*band.getFameLevel()));
            System.out.println("XP: " + band.getXP() + " -> " + (band.getXP() + 100*band.getFameLevel()));
            band.gainFans(200*band.getFameLevel());
            band.addXP(100*band.getFameLevel());
        } else if (attendancePercent < 80 && attendancePercent >= 60){
            System.out.println("Could have been better.\nAttendance: " + attendancePercent);
            System.out.println("Fans: " + band.getFans() + " -> " + (band.getFans() + 100*band.getFameLevel()));
            System.out.println("XP: " + band.getXP() + " -> " + (band.getXP() + 75*band.getFameLevel()));
            band.gainFans(100*band.getFameLevel());
            band.addXP(75*band.getFameLevel());
        } else if (attendancePercent < 60 && attendancePercent >= 0){
            System.out.println("Well... try again.\nAttendance: " + attendancePercent);
            System.out.println("Fans: " + band.getFans() + " -> " + (band.getFans() + 50*band.getFameLevel()));
            System.out.println("XP: " + band.getXP() + " -> " + (band.getXP() + 25*band.getFameLevel()));
            band.gainFans(50*band.getFameLevel());
            band.addXP(25*band.getFameLevel());
        }
        System.out.println("Money: $" + band.getMoney() + " -> $" + (band.getMoney() + venue.getPayoutAmount()));
        band.earnMoney(venue.getPayoutAmount());
    }

}
