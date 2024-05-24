package services;

import com.example.gestioneDispositivi.exceptions.NotFoundException;
import entities.Dispositivo;
import enums.StatoDispositivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import repositories.DispositivoRepository;

@Service
public class DispositivoService {

    @Autowired
    private DispositivoRepository dispositivoRepository;

    public Dispositivo save(Dispositivo body){
        body.setStato(StatoDispositivo.DISPONIBILE);
        return dispositivoRepository.save(body);
    }

    public Page<Dispositivo> getDispositivi(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return dispositivoRepository.findAll(pageable);
    }

    public Dispositivo findById(Long id){
        return dispositivoRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(Long id){
        Dispositivo found = this.findById(id);
        dispositivoRepository.delete(found);
    }
}
