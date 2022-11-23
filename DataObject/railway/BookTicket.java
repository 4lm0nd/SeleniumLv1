package railway;

public class BookTicket {
    private String DepartDate;
    private String DepartStation;
    private String ArriveStation;
    private String SeatType;
    private String TicketAmount;

    public BookTicket(String departDate, String departStation, String arriveStation, String seatType, String ticketAmount) {
        this.DepartDate = getDepartDate(departDate);
        this.DepartStation = getDepartStation(departStation);
        this.ArriveStation = getArriveStation(arriveStation);
        this.SeatType = getSeatType(seatType);
        this.TicketAmount = getTicketAmount(ticketAmount);

    }

    public String getDepartDate(String departDate){
       DepartDate = departDate;
        return DepartDate;
    }

    public String getDepartStation(String departStation){
        DepartStation = departStation;
        return  DepartStation;
    }

    public String getArriveStation(String arriveStation){
        ArriveStation = arriveStation;
        return ArriveStation;
    }

    public String getSeatType ( String seatType){
        SeatType = seatType;
        return SeatType;
    }

    public String getTicketAmount (String ticketAmount){
        TicketAmount = ticketAmount;
        return TicketAmount;
    }
}
