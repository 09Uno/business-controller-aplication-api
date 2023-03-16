package com.codetoyou.businessapi.rest.client;

import com.codetoyou.businessapi.model.ClientModel;
import com.codetoyou.businessapi.model.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/clients")
@CrossOrigin(origins = "*")
public class ClientController {

  @Autowired
  private ClientRepository clientRepository;

  @GetMapping
  public List<ClientRequest> getList() {
    return clientRepository
      .findAll()
      .stream()
      .map(ClientRequest::fromModel)
      .collect(Collectors.toList());
  }

  @GetMapping("{id}")
  public ResponseEntity<ClientRequest> find(@PathVariable Long id) {
    Optional<ClientModel> clientExist = clientRepository.findById(id);
    if (clientExist.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    var client = clientExist.map(ClientRequest::fromModel).get();
    return ResponseEntity.ok(client);
  }

  @PostMapping
  public ResponseEntity<ClientRequest> save(
    @RequestBody ClientRequest clientRequest
  ) {
    ClientModel client = clientRequest.toModel();
    clientRepository.save(client);

    return ResponseEntity.ok(ClientRequest.fromModel(client));
  }

  @PutMapping("{id}")
  public ResponseEntity<Void> update(
    @PathVariable Long id,
    @RequestBody ClientRequest clientRequest
  ) {
    java.util.Optional<ClientModel> clientExist = clientRepository.findById(id);
    if (clientExist.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    ClientModel clientEntity = clientRequest.toModel();
    clientEntity.setId(id);
    clientRepository.save(clientEntity);

    return ResponseEntity.ok().build();
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Void> del(@PathVariable Long id) {
    Optional<ClientModel> clientExist = clientRepository.findById(id);
    if (!clientExist.isPresent()) {
      return ResponseEntity.notFound().build();
    }

    clientRepository.delete(clientExist.get());
    return ResponseEntity.noContent().build();
  }
}
