package railway;

public class BookTicket {

    public String getDepartDate(String departDate) {
        return departDate;
    }

    public String getDepartStation(String departStation) {
        return departStation;
    }

    public String getArriveStation(String arriveStation) {
        return arriveStation;
    }

    public String getSeatType(String seatType) {
        return seatType;
    }

    public String getTicketAmount(String ticketAmount) {
        return ticketAmount;
    }

    public void setDepartDate(String departDate) {
        departDate = departDate;
    }

    public void setDepartStation(String departStation) {
        departStation = departStation;
    }

    public void setArriveStation(String arriveStation) {
        arriveStation = arriveStation;
    }

    public void setSeatType(String seatType) {
        seatType = seatType;
    }

    public void setTicketAmount(String ticketAmount) {
        ticketAmount = ticketAmount;
    }

    public BookTicket(String date, String departAt, String arriveAt, String seat, String amount) {
        this.dateDepart = date;
        this.departAt = departAt;
        this.arriveAt = arriveAt;
        this.seatType = seat;
        this.amount = amount;
    }
    private String dateDepart;
    private String departAt;
    private String arriveAt;
    private String seatType;
    private String amount;
}


