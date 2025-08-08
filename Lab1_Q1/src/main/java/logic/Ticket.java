package logic;

public class Ticket {
    private int type;
    private int priceperstation;

    private Station start;
    private Station end;

    public Ticket(int type, Station start, Station end) {
        setType(type);
        setStation(start, end);
    }

    public int getType() {
        return type;
    }

    public int getPricePerStation() {
        return priceperstation;
    }

    public Station getStart() {
        return start;
    }

    public Station getEnd() {
        return end;
    }

    public void setType(int type) {
        if (type < 0 || type > 2) {
            this.type = 1;
            return;
        }

        this.type = type;

        switch (type) {
            case 0:
                this.priceperstation = 30;
                break;
            case 1:
                this.priceperstation = 30;
                break;
            case 2:
                this.priceperstation = 25;
                break;
        }
    }

    public void setStation(Station start, Station end) {
        this.start = start;
        this.end = end;
    }

    public double calculatePrice() {
        int distance = getStationDistance(start, end);

        if (distance == 0)
            return -1;

        switch (type) {
            case 0:
                if (distance > 4) {
                    return (priceperstation * distance) * 0.8;
                } else {
                    return priceperstation * distance;
                }

            case 1:
                return priceperstation * distance;
            case 2:
                if (distance > 6) {
                    return -1;
                }

                return distance * priceperstation * 0.6;
            default:
                return -1;
        }

    }

    public String getDescription() {
        String typename;

        switch (type) {

            case 0:
                typename = "Student";
                break;
            case 1:
                typename = "Adult";
                break;
            case 2:
                typename = "Elderly";
                break;
            default:
                typename = "Invalid";
        }

        if (!isStationValid(start, end))
            typename = "Invalid";

        return typename + " Ticket, from " + start.getName() + " to " + end.getName();
    }

    public boolean isStationValid(Station start, Station end) {
        if (start == null || end == null) {
            return false;
        }

        if (type == 2 && this.getStationDistance(start, end) > 6) {
            return false;
        }

        if (start == end || start.getName().equals(end.getName())) {
            return false;
        }
        return true;
    }

    public int getStationDistance(Station start, Station end) {
        return Math.abs(start.getNumber() - end.getNumber());
    }

}
