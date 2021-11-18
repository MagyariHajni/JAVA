public enum TicketType {

    FREE_PASS(0),FULL(1),FULL_VIP(2), ONE_DAY(3),ONE_DAY_VIP(4);

    private final int ticketTypeCode;

    TicketType(int ticketTypeCode) {
        this.ticketTypeCode = ticketTypeCode;
    }

    public int getTicketTypeCode() {
        return ticketTypeCode;
    }
}
