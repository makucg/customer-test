package com.cuatroochenta.ticketing.service.impl;

import com.cuatroochenta.ticketing.domain.Customer;
import com.cuatroochenta.ticketing.repository.CustomerRepository;
import com.cuatroochenta.ticketing.service.CustomerService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Customer}.
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer) {
        log.debug("Request to save Customer : {}", customer);
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        log.debug("Request to update Customer : {}", customer);
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> partialUpdate(Customer customer) {
        log.debug("Request to partially update Customer : {}", customer);

        return customerRepository
            .findById(customer.getId())
            .map(existingCustomer -> {
                if (customer.getName() != null) {
                    existingCustomer.setName(customer.getName());
                }
                if (customer.getLastName() != null) {
                    existingCustomer.setLastName(customer.getLastName());
                }
                if (customer.getCif() != null) {
                    existingCustomer.setCif(customer.getCif());
                }
                if (customer.getDirection() != null) {
                    existingCustomer.setDirection(customer.getDirection());
                }
                if (customer.getMunicipality() != null) {
                    existingCustomer.setMunicipality(customer.getMunicipality());
                }
                if (customer.getPc() != null) {
                    existingCustomer.setPc(customer.getPc());
                }
                if (customer.getTelephoneNumber() != null) {
                    existingCustomer.setTelephoneNumber(customer.getTelephoneNumber());
                }
                if (customer.getEmail() != null) {
                    existingCustomer.setEmail(customer.getEmail());
                }
                if (customer.getPrivacyUrl() != null) {
                    existingCustomer.setPrivacyUrl(customer.getPrivacyUrl());
                }
                if (customer.getCancelUrl() != null) {
                    existingCustomer.setCancelUrl(customer.getCancelUrl());
                }
                if (customer.getEnterprise() != null) {
                    existingCustomer.setEnterprise(customer.getEnterprise());
                }
                if (customer.getRegistryCode() != null) {
                    existingCustomer.setRegistryCode(customer.getRegistryCode());
                }
                if (customer.getMainRoomName() != null) {
                    existingCustomer.setMainRoomName(customer.getMainRoomName());
                }
                if (customer.getSubdomain() != null) {
                    existingCustomer.setSubdomain(customer.getSubdomain());
                }
                if (customer.getMenuTpv() != null) {
                    existingCustomer.setMenuTpv(customer.getMenuTpv());
                }
                if (customer.getMenuClientes() != null) {
                    existingCustomer.setMenuClientes(customer.getMenuClientes());
                }
                if (customer.getMenuIntegraciones() != null) {
                    existingCustomer.setMenuIntegraciones(customer.getMenuIntegraciones());
                }
                if (customer.getMenuSalas() != null) {
                    existingCustomer.setMenuSalas(customer.getMenuSalas());
                }
                if (customer.getMenuPerfil() != null) {
                    existingCustomer.setMenuPerfil(customer.getMenuPerfil());
                }
                if (customer.getMenuAyuda() != null) {
                    existingCustomer.setMenuAyuda(customer.getMenuAyuda());
                }
                if (customer.getMenuTaquilla() != null) {
                    existingCustomer.setMenuTaquilla(customer.getMenuTaquilla());
                }
                if (customer.getMenuAbonos() != null) {
                    existingCustomer.setMenuAbonos(customer.getMenuAbonos());
                }
                if (customer.getMenuICAA() != null) {
                    existingCustomer.setMenuICAA(customer.getMenuICAA());
                }
                if (customer.getDisclaimers() != null) {
                    existingCustomer.setDisclaimers(customer.getDisclaimers());
                }
                if (customer.getReglas() != null) {
                    existingCustomer.setReglas(customer.getReglas());
                }
                if (customer.getUsuarios() != null) {
                    existingCustomer.setUsuarios(customer.getUsuarios());
                }
                if (customer.getCupones() != null) {
                    existingCustomer.setCupones(customer.getCupones());
                }
                if (customer.getVentaCruzada() != null) {
                    existingCustomer.setVentaCruzada(customer.getVentaCruzada());
                }
                if (customer.getPacks() != null) {
                    existingCustomer.setPacks(customer.getPacks());
                }
                if (customer.getMenuTiposEvento() != null) {
                    existingCustomer.setMenuTiposEvento(customer.getMenuTiposEvento());
                }
                if (customer.getMenuPlantillasPrecios() != null) {
                    existingCustomer.setMenuPlantillasPrecios(customer.getMenuPlantillasPrecios());
                }
                if (customer.getMenuPlantillasReserva() != null) {
                    existingCustomer.setMenuPlantillasReserva(customer.getMenuPlantillasReserva());
                }
                if (customer.getMenuTarifas() != null) {
                    existingCustomer.setMenuTarifas(customer.getMenuTarifas());
                }
                if (customer.getMenuComprasReservas() != null) {
                    existingCustomer.setMenuComprasReservas(customer.getMenuComprasReservas());
                }
                if (customer.getMenuInformes() != null) {
                    existingCustomer.setMenuInformes(customer.getMenuInformes());
                }
                if (customer.getMenuInformesSesion() != null) {
                    existingCustomer.setMenuInformesSesion(customer.getMenuInformesSesion());
                }
                if (customer.getThirdParty() != null) {
                    existingCustomer.setThirdParty(customer.getThirdParty());
                }
                if (customer.getMenuAforoPorDias() != null) {
                    existingCustomer.setMenuAforoPorDias(customer.getMenuAforoPorDias());
                }
                if (customer.getStatus() != null) {
                    existingCustomer.setStatus(customer.getStatus());
                }

                return existingCustomer;
            })
            .map(customerRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Customer> findAll(Pageable pageable) {
        log.debug("Request to get all Customers");
        return customerRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Customer> findOne(Long id) {
        log.debug("Request to get Customer : {}", id);
        return customerRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Customer : {}", id);
        customerRepository.deleteById(id);
    }
}
