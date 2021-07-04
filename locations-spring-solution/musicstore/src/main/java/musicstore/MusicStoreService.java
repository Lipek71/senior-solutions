package musicstore;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class MusicStoreService {

    private ModelMapper modelMapper;
    private AtomicLong idGenerator = new AtomicLong();
    private List<Instrument> instrumentList = Collections.synchronizedList(new ArrayList<>(List.of(
            new Instrument(idGenerator.incrementAndGet(), "Fender", InstrumentType.ELECTRIC_GUITAR, 90000, LocalDate.of(2021,06,10)),
            new Instrument(idGenerator.incrementAndGet(), "Jackson", InstrumentType.ELECTRIC_GUITAR, 170000, LocalDate.of(2021,06,10)),
            new Instrument(idGenerator.incrementAndGet(), "Tanglewood", InstrumentType.ACOUSTIC_GUITAR, 95000, LocalDate.of(2021,06,10)),
            new Instrument(idGenerator.incrementAndGet(), "Fender", InstrumentType.ACOUSTIC_GUITAR, 95000, LocalDate.of(2021,06,10)),
            new Instrument(idGenerator.incrementAndGet(), "Fender Children", InstrumentType.ACOUSTIC_GUITAR, 55000, LocalDate.of(2021,06,10))
    )));


    public MusicStoreService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public List<InstrumentDTO> listInstruments(Optional<String> brand, Optional<Integer> price){
        Type targetListType = new TypeToken<List<InstrumentDTO>>(){}.getType();
        List<Instrument> filtered = instrumentList.stream()
                .filter(i -> brand.isEmpty() || i.getBrand().equalsIgnoreCase(brand.get()))
                .filter(i -> price.isEmpty() || i.getPrice() == price.get())
                .collect(Collectors.toList());
        return modelMapper.map(filtered, targetListType);
    }

    public InstrumentDTO createInstruments(CreateInstrumentCommand command) {
        Instrument instrument = new Instrument(idGenerator.incrementAndGet()
                , command.getBrand()
                , command.getInstrumentType()
                , command.getPrice()
                , LocalDate.now());
        instrumentList.add(instrument);
        return modelMapper.map(instrument, InstrumentDTO.class);
    }

    public InstrumentDTO updatePrice(long id, UpdatePriceCommand command) {
        Instrument instrument = instrumentList.stream()
                .filter(i -> i.getId() == id)
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Instrument not found: " + id));
        if(instrument.getPrice() != command.getPrice()) {
            instrument.setPrice(command.getPrice());
            instrument.setPostDate(LocalDate.now());
        }
        return modelMapper.map(instrument, InstrumentDTO.class);
    }

    public void deleteInstrument(long id) {
        Instrument instrument = instrumentList.stream()
                .filter(i -> i.getId() == id)
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Instrument not found: " + id));
        instrumentList.remove(instrument);
    }

    public void deleteInstrumentAll() {
        instrumentList.clear();
        idGenerator = new AtomicLong();
    }

    public InstrumentDTO listInstrumentById(long id) {
        Instrument instrument = instrumentList.stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Instrument not found: " + id));
        return modelMapper.map(instrument, InstrumentDTO.class);
    }
}
