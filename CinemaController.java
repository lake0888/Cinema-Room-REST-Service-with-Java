package cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/")
public class CinemaController {
    final CinemaService cinemaService;

    @Autowired
    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping(path = "seats")
    public ResponseEntity<Cinema> findAll() {
        return new ResponseEntity<>(cinemaService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "seats/{row}/{column}")
    public ResponseEntity<Seat> findSeat(
            @PathVariable(name = "row") int row, @PathVariable(name = "column") int column
    ) {
        return new ResponseEntity<>(cinemaService.findByRowColumn(row, column), HttpStatus.OK);
    }

    @PostMapping(path = "purchase")
    public ResponseEntity<Purchase> save(@RequestBody Seat newSeat) {
        return new ResponseEntity<>(cinemaService.save(newSeat), HttpStatus.OK);
    }

    @PostMapping(path = "return")
    public ResponseEntity<Refund> makeRefund(@RequestBody RequestRefund requestRefund) {
        return new ResponseEntity<>(cinemaService.refund(requestRefund), HttpStatus.OK);
    }

    @GetMapping(path = "stats")
    public ResponseEntity<Stats> showStats(@RequestParam(required = false) String password) {
        return new ResponseEntity<>(cinemaService.showStats(password), HttpStatus.OK);
    }
}
