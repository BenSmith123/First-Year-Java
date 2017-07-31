
/**
 * The RynoAir class is a concrete class that extends the abstract class Airline.
 *
 * @author Ben Smith
 *
 */

public class RynoAir extends Airline{
	
	public Seat reserveFirstClass(Flight flight, SeatType seatType) {
        Seat attemptedSeat = flight.getSeatMapArray().queryAvailableFirstClassSeat(seatType);

        if (attemptedSeat != null) {
            attemptedSeat.setIsReserved(true);
            System.out.println("Booked " + attemptedSeat.getSeatPosition() + " on flight " + flight.getFlightNumber()+"\n");
            return attemptedSeat;
        }
        
        for (int r = 0; r < flight.getSeatMapArray().getMaxRows(); r++) {
            for (int c = 0; c < flight.getSeatMapArray().getMaxColumns(); c++) {

                Seat seat = flight.getSeatMapArray().getSeat(r + 1, (char) (c + 65));
                
                if ((seat.getSeatType() != SeatType.AISLE) && seat.getIsFirstClass() == false && seat.getIsReserved() == false && ((flight.getSeatMapArray().getRight(seat) != null && flight.getSeatMapArray().getRight(seat).getIsReserved() == false) || (flight.getSeatMapArray().getLeft(seat) != null && flight.getSeatMapArray().getLeft(seat).getIsReserved() == false))) {

                    if (flight.getSeatMapArray().getLeft(seat) != null && flight.getSeatMapArray().getLeft(seat).getIsReserved() == false) {
                        flight.bookSeat(flight.getSeatMapArray().getLeft(seat));
                        flight.bookSeat(seat);

                        System.out.println("Booked seats: " + seat.getSeatPosition() + 
                        " and "+ flight.getSeatMapArray().getLeft(seat).getSeatPosition() +
                        " on flight \n" + flight.getFlightNumber());

                    } else {

                        flight.getSeatMapArray().getRight(seat).setIsReserved(true);
                        flight.bookSeat(seat);

                        System.out.println("Booked seats " + seat.getSeatPosition() +
                        " and " + flight.getSeatMapArray().getRight(seat).getSeatPosition() +
                        " on flight \n" + flight.getFlightNumber());
                        
                    }

                    return seat;

                }
            }
        }

        return null;

	}
}
