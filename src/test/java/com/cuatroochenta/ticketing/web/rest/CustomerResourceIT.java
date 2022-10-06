package com.cuatroochenta.ticketing.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.cuatroochenta.ticketing.IntegrationTest;
import com.cuatroochenta.ticketing.domain.Customer;
import com.cuatroochenta.ticketing.domain.enumeration.Status;
import com.cuatroochenta.ticketing.repository.CustomerRepository;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link CustomerResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class CustomerResourceIT {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_LAST_NAME = "AAAAAAAAAA";
    private static final String UPDATED_LAST_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_CIF = "AAAAAAAAAA";
    private static final String UPDATED_CIF = "BBBBBBBBBB";

    private static final String DEFAULT_DIRECTION = "AAAAAAAAAA";
    private static final String UPDATED_DIRECTION = "BBBBBBBBBB";

    private static final String DEFAULT_MUNICIPALITY = "AAAAAAAAAA";
    private static final String UPDATED_MUNICIPALITY = "BBBBBBBBBB";

    private static final String DEFAULT_PC = "AAAAAAAAAA";
    private static final String UPDATED_PC = "BBBBBBBBBB";

    private static final String DEFAULT_TELEPHONE_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_TELEPHONE_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL = "BBBBBBBBBB";

    private static final String DEFAULT_PRIVACY_URL = "AAAAAAAAAA";
    private static final String UPDATED_PRIVACY_URL = "BBBBBBBBBB";

    private static final String DEFAULT_CANCEL_URL = "AAAAAAAAAA";
    private static final String UPDATED_CANCEL_URL = "BBBBBBBBBB";

    private static final String DEFAULT_ENTERPRISE = "AAAAAAAAAA";
    private static final String UPDATED_ENTERPRISE = "BBBBBBBBBB";

    private static final String DEFAULT_REGISTRY_CODE = "AAAAAAAAAA";
    private static final String UPDATED_REGISTRY_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_MAIN_ROOM_NAME = "AAAAAAAAAA";
    private static final String UPDATED_MAIN_ROOM_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_SUBDOMAIN = "AAAAAAAAAA";
    private static final String UPDATED_SUBDOMAIN = "BBBBBBBBBB";

    private static final String DEFAULT_MENU_TPV = "AAAAAAAAAA";
    private static final String UPDATED_MENU_TPV = "BBBBBBBBBB";

    private static final String DEFAULT_MENU_CLIENTES = "AAAAAAAAAA";
    private static final String UPDATED_MENU_CLIENTES = "BBBBBBBBBB";

    private static final String DEFAULT_MENU_INTEGRACIONES = "AAAAAAAAAA";
    private static final String UPDATED_MENU_INTEGRACIONES = "BBBBBBBBBB";

    private static final String DEFAULT_MENU_SALAS = "AAAAAAAAAA";
    private static final String UPDATED_MENU_SALAS = "BBBBBBBBBB";

    private static final String DEFAULT_MENU_PERFIL = "AAAAAAAAAA";
    private static final String UPDATED_MENU_PERFIL = "BBBBBBBBBB";

    private static final String DEFAULT_MENU_AYUDA = "AAAAAAAAAA";
    private static final String UPDATED_MENU_AYUDA = "BBBBBBBBBB";

    private static final String DEFAULT_MENU_TAQUILLA = "AAAAAAAAAA";
    private static final String UPDATED_MENU_TAQUILLA = "BBBBBBBBBB";

    private static final String DEFAULT_MENU_ABONOS = "AAAAAAAAAA";
    private static final String UPDATED_MENU_ABONOS = "BBBBBBBBBB";

    private static final String DEFAULT_MENU_ICAA = "AAAAAAAAAA";
    private static final String UPDATED_MENU_ICAA = "BBBBBBBBBB";

    private static final String DEFAULT_DISCLAIMERS = "AAAAAAAAAA";
    private static final String UPDATED_DISCLAIMERS = "BBBBBBBBBB";

    private static final String DEFAULT_REGLAS = "AAAAAAAAAA";
    private static final String UPDATED_REGLAS = "BBBBBBBBBB";

    private static final String DEFAULT_USUARIOS = "AAAAAAAAAA";
    private static final String UPDATED_USUARIOS = "BBBBBBBBBB";

    private static final String DEFAULT_CUPONES = "AAAAAAAAAA";
    private static final String UPDATED_CUPONES = "BBBBBBBBBB";

    private static final String DEFAULT_VENTA_CRUZADA = "AAAAAAAAAA";
    private static final String UPDATED_VENTA_CRUZADA = "BBBBBBBBBB";

    private static final String DEFAULT_PACKS = "AAAAAAAAAA";
    private static final String UPDATED_PACKS = "BBBBBBBBBB";

    private static final String DEFAULT_MENU_TIPOS_EVENTO = "AAAAAAAAAA";
    private static final String UPDATED_MENU_TIPOS_EVENTO = "BBBBBBBBBB";

    private static final String DEFAULT_MENU_PLANTILLAS_PRECIOS = "AAAAAAAAAA";
    private static final String UPDATED_MENU_PLANTILLAS_PRECIOS = "BBBBBBBBBB";

    private static final String DEFAULT_MENU_PLANTILLAS_RESERVA = "AAAAAAAAAA";
    private static final String UPDATED_MENU_PLANTILLAS_RESERVA = "BBBBBBBBBB";

    private static final String DEFAULT_MENU_TARIFAS = "AAAAAAAAAA";
    private static final String UPDATED_MENU_TARIFAS = "BBBBBBBBBB";

    private static final String DEFAULT_MENU_COMPRAS_RESERVAS = "AAAAAAAAAA";
    private static final String UPDATED_MENU_COMPRAS_RESERVAS = "BBBBBBBBBB";

    private static final String DEFAULT_MENU_INFORMES = "AAAAAAAAAA";
    private static final String UPDATED_MENU_INFORMES = "BBBBBBBBBB";

    private static final String DEFAULT_MENU_INFORMES_SESION = "AAAAAAAAAA";
    private static final String UPDATED_MENU_INFORMES_SESION = "BBBBBBBBBB";

    private static final String DEFAULT_THIRD_PARTY = "AAAAAAAAAA";
    private static final String UPDATED_THIRD_PARTY = "BBBBBBBBBB";

    private static final String DEFAULT_MENU_AFORO_POR_DIAS = "AAAAAAAAAA";
    private static final String UPDATED_MENU_AFORO_POR_DIAS = "BBBBBBBBBB";

    private static final Status DEFAULT_STATUS = Status.CREATED;
    private static final Status UPDATED_STATUS = Status.EDITED;

    private static final String ENTITY_API_URL = "/api/customers";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restCustomerMockMvc;

    private Customer customer;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Customer createEntity(EntityManager em) {
        Customer customer = new Customer()
            .name(DEFAULT_NAME)
            .lastName(DEFAULT_LAST_NAME)
            .cif(DEFAULT_CIF)
            .direction(DEFAULT_DIRECTION)
            .municipality(DEFAULT_MUNICIPALITY)
            .pc(DEFAULT_PC)
            .telephoneNumber(DEFAULT_TELEPHONE_NUMBER)
            .email(DEFAULT_EMAIL)
            .privacyUrl(DEFAULT_PRIVACY_URL)
            .cancelUrl(DEFAULT_CANCEL_URL)
            .enterprise(DEFAULT_ENTERPRISE)
            .registryCode(DEFAULT_REGISTRY_CODE)
            .mainRoomName(DEFAULT_MAIN_ROOM_NAME)
            .subdomain(DEFAULT_SUBDOMAIN)
            .menuTpv(DEFAULT_MENU_TPV)
            .menuClientes(DEFAULT_MENU_CLIENTES)
            .menuIntegraciones(DEFAULT_MENU_INTEGRACIONES)
            .menuSalas(DEFAULT_MENU_SALAS)
            .menuPerfil(DEFAULT_MENU_PERFIL)
            .menuAyuda(DEFAULT_MENU_AYUDA)
            .menuTaquilla(DEFAULT_MENU_TAQUILLA)
            .menuAbonos(DEFAULT_MENU_ABONOS)
            .menuICAA(DEFAULT_MENU_ICAA)
            .disclaimers(DEFAULT_DISCLAIMERS)
            .reglas(DEFAULT_REGLAS)
            .usuarios(DEFAULT_USUARIOS)
            .cupones(DEFAULT_CUPONES)
            .ventaCruzada(DEFAULT_VENTA_CRUZADA)
            .packs(DEFAULT_PACKS)
            .menuTiposEvento(DEFAULT_MENU_TIPOS_EVENTO)
            .menuPlantillasPrecios(DEFAULT_MENU_PLANTILLAS_PRECIOS)
            .menuPlantillasReserva(DEFAULT_MENU_PLANTILLAS_RESERVA)
            .menuTarifas(DEFAULT_MENU_TARIFAS)
            .menuComprasReservas(DEFAULT_MENU_COMPRAS_RESERVAS)
            .menuInformes(DEFAULT_MENU_INFORMES)
            .menuInformesSesion(DEFAULT_MENU_INFORMES_SESION)
            .thirdParty(DEFAULT_THIRD_PARTY)
            .menuAforoPorDias(DEFAULT_MENU_AFORO_POR_DIAS)
            .status(DEFAULT_STATUS);
        return customer;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Customer createUpdatedEntity(EntityManager em) {
        Customer customer = new Customer()
            .name(UPDATED_NAME)
            .lastName(UPDATED_LAST_NAME)
            .cif(UPDATED_CIF)
            .direction(UPDATED_DIRECTION)
            .municipality(UPDATED_MUNICIPALITY)
            .pc(UPDATED_PC)
            .telephoneNumber(UPDATED_TELEPHONE_NUMBER)
            .email(UPDATED_EMAIL)
            .privacyUrl(UPDATED_PRIVACY_URL)
            .cancelUrl(UPDATED_CANCEL_URL)
            .enterprise(UPDATED_ENTERPRISE)
            .registryCode(UPDATED_REGISTRY_CODE)
            .mainRoomName(UPDATED_MAIN_ROOM_NAME)
            .subdomain(UPDATED_SUBDOMAIN)
            .menuTpv(UPDATED_MENU_TPV)
            .menuClientes(UPDATED_MENU_CLIENTES)
            .menuIntegraciones(UPDATED_MENU_INTEGRACIONES)
            .menuSalas(UPDATED_MENU_SALAS)
            .menuPerfil(UPDATED_MENU_PERFIL)
            .menuAyuda(UPDATED_MENU_AYUDA)
            .menuTaquilla(UPDATED_MENU_TAQUILLA)
            .menuAbonos(UPDATED_MENU_ABONOS)
            .menuICAA(UPDATED_MENU_ICAA)
            .disclaimers(UPDATED_DISCLAIMERS)
            .reglas(UPDATED_REGLAS)
            .usuarios(UPDATED_USUARIOS)
            .cupones(UPDATED_CUPONES)
            .ventaCruzada(UPDATED_VENTA_CRUZADA)
            .packs(UPDATED_PACKS)
            .menuTiposEvento(UPDATED_MENU_TIPOS_EVENTO)
            .menuPlantillasPrecios(UPDATED_MENU_PLANTILLAS_PRECIOS)
            .menuPlantillasReserva(UPDATED_MENU_PLANTILLAS_RESERVA)
            .menuTarifas(UPDATED_MENU_TARIFAS)
            .menuComprasReservas(UPDATED_MENU_COMPRAS_RESERVAS)
            .menuInformes(UPDATED_MENU_INFORMES)
            .menuInformesSesion(UPDATED_MENU_INFORMES_SESION)
            .thirdParty(UPDATED_THIRD_PARTY)
            .menuAforoPorDias(UPDATED_MENU_AFORO_POR_DIAS)
            .status(UPDATED_STATUS);
        return customer;
    }

    @BeforeEach
    public void initTest() {
        customer = createEntity(em);
    }

    @Test
    @Transactional
    void createCustomer() throws Exception {
        int databaseSizeBeforeCreate = customerRepository.findAll().size();
        // Create the Customer
        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isCreated());

        // Validate the Customer in the database
        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeCreate + 1);
        Customer testCustomer = customerList.get(customerList.size() - 1);
        assertThat(testCustomer.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testCustomer.getLastName()).isEqualTo(DEFAULT_LAST_NAME);
        assertThat(testCustomer.getCif()).isEqualTo(DEFAULT_CIF);
        assertThat(testCustomer.getDirection()).isEqualTo(DEFAULT_DIRECTION);
        assertThat(testCustomer.getMunicipality()).isEqualTo(DEFAULT_MUNICIPALITY);
        assertThat(testCustomer.getPc()).isEqualTo(DEFAULT_PC);
        assertThat(testCustomer.getTelephoneNumber()).isEqualTo(DEFAULT_TELEPHONE_NUMBER);
        assertThat(testCustomer.getEmail()).isEqualTo(DEFAULT_EMAIL);
        assertThat(testCustomer.getPrivacyUrl()).isEqualTo(DEFAULT_PRIVACY_URL);
        assertThat(testCustomer.getCancelUrl()).isEqualTo(DEFAULT_CANCEL_URL);
        assertThat(testCustomer.getEnterprise()).isEqualTo(DEFAULT_ENTERPRISE);
        assertThat(testCustomer.getRegistryCode()).isEqualTo(DEFAULT_REGISTRY_CODE);
        assertThat(testCustomer.getMainRoomName()).isEqualTo(DEFAULT_MAIN_ROOM_NAME);
        assertThat(testCustomer.getSubdomain()).isEqualTo(DEFAULT_SUBDOMAIN);
        assertThat(testCustomer.getMenuTpv()).isEqualTo(DEFAULT_MENU_TPV);
        assertThat(testCustomer.getMenuClientes()).isEqualTo(DEFAULT_MENU_CLIENTES);
        assertThat(testCustomer.getMenuIntegraciones()).isEqualTo(DEFAULT_MENU_INTEGRACIONES);
        assertThat(testCustomer.getMenuSalas()).isEqualTo(DEFAULT_MENU_SALAS);
        assertThat(testCustomer.getMenuPerfil()).isEqualTo(DEFAULT_MENU_PERFIL);
        assertThat(testCustomer.getMenuAyuda()).isEqualTo(DEFAULT_MENU_AYUDA);
        assertThat(testCustomer.getMenuTaquilla()).isEqualTo(DEFAULT_MENU_TAQUILLA);
        assertThat(testCustomer.getMenuAbonos()).isEqualTo(DEFAULT_MENU_ABONOS);
        assertThat(testCustomer.getMenuICAA()).isEqualTo(DEFAULT_MENU_ICAA);
        assertThat(testCustomer.getDisclaimers()).isEqualTo(DEFAULT_DISCLAIMERS);
        assertThat(testCustomer.getReglas()).isEqualTo(DEFAULT_REGLAS);
        assertThat(testCustomer.getUsuarios()).isEqualTo(DEFAULT_USUARIOS);
        assertThat(testCustomer.getCupones()).isEqualTo(DEFAULT_CUPONES);
        assertThat(testCustomer.getVentaCruzada()).isEqualTo(DEFAULT_VENTA_CRUZADA);
        assertThat(testCustomer.getPacks()).isEqualTo(DEFAULT_PACKS);
        assertThat(testCustomer.getMenuTiposEvento()).isEqualTo(DEFAULT_MENU_TIPOS_EVENTO);
        assertThat(testCustomer.getMenuPlantillasPrecios()).isEqualTo(DEFAULT_MENU_PLANTILLAS_PRECIOS);
        assertThat(testCustomer.getMenuPlantillasReserva()).isEqualTo(DEFAULT_MENU_PLANTILLAS_RESERVA);
        assertThat(testCustomer.getMenuTarifas()).isEqualTo(DEFAULT_MENU_TARIFAS);
        assertThat(testCustomer.getMenuComprasReservas()).isEqualTo(DEFAULT_MENU_COMPRAS_RESERVAS);
        assertThat(testCustomer.getMenuInformes()).isEqualTo(DEFAULT_MENU_INFORMES);
        assertThat(testCustomer.getMenuInformesSesion()).isEqualTo(DEFAULT_MENU_INFORMES_SESION);
        assertThat(testCustomer.getThirdParty()).isEqualTo(DEFAULT_THIRD_PARTY);
        assertThat(testCustomer.getMenuAforoPorDias()).isEqualTo(DEFAULT_MENU_AFORO_POR_DIAS);
        assertThat(testCustomer.getStatus()).isEqualTo(DEFAULT_STATUS);
    }

    @Test
    @Transactional
    void createCustomerWithExistingId() throws Exception {
        // Create the Customer with an existing ID
        customer.setId(1L);

        int databaseSizeBeforeCreate = customerRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        // Validate the Customer in the database
        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setName(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkLastNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setLastName(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkCifIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setCif(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkDirectionIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setDirection(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMunicipalityIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setMunicipality(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPcIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setPc(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkTelephoneNumberIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setTelephoneNumber(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkEmailIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setEmail(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPrivacyUrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setPrivacyUrl(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkCancelUrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setCancelUrl(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkEnterpriseIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setEnterprise(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRegistryCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setRegistryCode(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMainRoomNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setMainRoomName(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkSubdomainIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setSubdomain(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMenuTpvIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setMenuTpv(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMenuClientesIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setMenuClientes(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMenuIntegracionesIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setMenuIntegraciones(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMenuSalasIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setMenuSalas(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMenuPerfilIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setMenuPerfil(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMenuAyudaIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setMenuAyuda(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMenuTaquillaIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setMenuTaquilla(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMenuAbonosIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setMenuAbonos(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMenuICAAIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setMenuICAA(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkDisclaimersIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setDisclaimers(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkReglasIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setReglas(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkUsuariosIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setUsuarios(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkCuponesIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setCupones(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkVentaCruzadaIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setVentaCruzada(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPacksIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setPacks(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMenuTiposEventoIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setMenuTiposEvento(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMenuPlantillasPreciosIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setMenuPlantillasPrecios(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMenuPlantillasReservaIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setMenuPlantillasReserva(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMenuTarifasIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setMenuTarifas(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMenuComprasReservasIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setMenuComprasReservas(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMenuInformesIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setMenuInformes(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMenuInformesSesionIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setMenuInformesSesion(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkThirdPartyIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setThirdParty(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMenuAforoPorDiasIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setMenuAforoPorDias(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkStatusIsRequired() throws Exception {
        int databaseSizeBeforeTest = customerRepository.findAll().size();
        // set the field null
        customer.setStatus(null);

        // Create the Customer, which fails.

        restCustomerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isBadRequest());

        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllCustomers() throws Exception {
        // Initialize the database
        customerRepository.saveAndFlush(customer);

        // Get all the customerList
        restCustomerMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(customer.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].lastName").value(hasItem(DEFAULT_LAST_NAME)))
            .andExpect(jsonPath("$.[*].cif").value(hasItem(DEFAULT_CIF)))
            .andExpect(jsonPath("$.[*].direction").value(hasItem(DEFAULT_DIRECTION)))
            .andExpect(jsonPath("$.[*].municipality").value(hasItem(DEFAULT_MUNICIPALITY)))
            .andExpect(jsonPath("$.[*].pc").value(hasItem(DEFAULT_PC)))
            .andExpect(jsonPath("$.[*].telephoneNumber").value(hasItem(DEFAULT_TELEPHONE_NUMBER)))
            .andExpect(jsonPath("$.[*].email").value(hasItem(DEFAULT_EMAIL)))
            .andExpect(jsonPath("$.[*].privacyUrl").value(hasItem(DEFAULT_PRIVACY_URL)))
            .andExpect(jsonPath("$.[*].cancelUrl").value(hasItem(DEFAULT_CANCEL_URL)))
            .andExpect(jsonPath("$.[*].enterprise").value(hasItem(DEFAULT_ENTERPRISE)))
            .andExpect(jsonPath("$.[*].registryCode").value(hasItem(DEFAULT_REGISTRY_CODE)))
            .andExpect(jsonPath("$.[*].mainRoomName").value(hasItem(DEFAULT_MAIN_ROOM_NAME)))
            .andExpect(jsonPath("$.[*].subdomain").value(hasItem(DEFAULT_SUBDOMAIN)))
            .andExpect(jsonPath("$.[*].menuTpv").value(hasItem(DEFAULT_MENU_TPV)))
            .andExpect(jsonPath("$.[*].menuClientes").value(hasItem(DEFAULT_MENU_CLIENTES)))
            .andExpect(jsonPath("$.[*].menuIntegraciones").value(hasItem(DEFAULT_MENU_INTEGRACIONES)))
            .andExpect(jsonPath("$.[*].menuSalas").value(hasItem(DEFAULT_MENU_SALAS)))
            .andExpect(jsonPath("$.[*].menuPerfil").value(hasItem(DEFAULT_MENU_PERFIL)))
            .andExpect(jsonPath("$.[*].menuAyuda").value(hasItem(DEFAULT_MENU_AYUDA)))
            .andExpect(jsonPath("$.[*].menuTaquilla").value(hasItem(DEFAULT_MENU_TAQUILLA)))
            .andExpect(jsonPath("$.[*].menuAbonos").value(hasItem(DEFAULT_MENU_ABONOS)))
            .andExpect(jsonPath("$.[*].menuICAA").value(hasItem(DEFAULT_MENU_ICAA)))
            .andExpect(jsonPath("$.[*].disclaimers").value(hasItem(DEFAULT_DISCLAIMERS)))
            .andExpect(jsonPath("$.[*].reglas").value(hasItem(DEFAULT_REGLAS)))
            .andExpect(jsonPath("$.[*].usuarios").value(hasItem(DEFAULT_USUARIOS)))
            .andExpect(jsonPath("$.[*].cupones").value(hasItem(DEFAULT_CUPONES)))
            .andExpect(jsonPath("$.[*].ventaCruzada").value(hasItem(DEFAULT_VENTA_CRUZADA)))
            .andExpect(jsonPath("$.[*].packs").value(hasItem(DEFAULT_PACKS)))
            .andExpect(jsonPath("$.[*].menuTiposEvento").value(hasItem(DEFAULT_MENU_TIPOS_EVENTO)))
            .andExpect(jsonPath("$.[*].menuPlantillasPrecios").value(hasItem(DEFAULT_MENU_PLANTILLAS_PRECIOS)))
            .andExpect(jsonPath("$.[*].menuPlantillasReserva").value(hasItem(DEFAULT_MENU_PLANTILLAS_RESERVA)))
            .andExpect(jsonPath("$.[*].menuTarifas").value(hasItem(DEFAULT_MENU_TARIFAS)))
            .andExpect(jsonPath("$.[*].menuComprasReservas").value(hasItem(DEFAULT_MENU_COMPRAS_RESERVAS)))
            .andExpect(jsonPath("$.[*].menuInformes").value(hasItem(DEFAULT_MENU_INFORMES)))
            .andExpect(jsonPath("$.[*].menuInformesSesion").value(hasItem(DEFAULT_MENU_INFORMES_SESION)))
            .andExpect(jsonPath("$.[*].thirdParty").value(hasItem(DEFAULT_THIRD_PARTY)))
            .andExpect(jsonPath("$.[*].menuAforoPorDias").value(hasItem(DEFAULT_MENU_AFORO_POR_DIAS)))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS.toString())));
    }

    @Test
    @Transactional
    void getCustomer() throws Exception {
        // Initialize the database
        customerRepository.saveAndFlush(customer);

        // Get the customer
        restCustomerMockMvc
            .perform(get(ENTITY_API_URL_ID, customer.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(customer.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.lastName").value(DEFAULT_LAST_NAME))
            .andExpect(jsonPath("$.cif").value(DEFAULT_CIF))
            .andExpect(jsonPath("$.direction").value(DEFAULT_DIRECTION))
            .andExpect(jsonPath("$.municipality").value(DEFAULT_MUNICIPALITY))
            .andExpect(jsonPath("$.pc").value(DEFAULT_PC))
            .andExpect(jsonPath("$.telephoneNumber").value(DEFAULT_TELEPHONE_NUMBER))
            .andExpect(jsonPath("$.email").value(DEFAULT_EMAIL))
            .andExpect(jsonPath("$.privacyUrl").value(DEFAULT_PRIVACY_URL))
            .andExpect(jsonPath("$.cancelUrl").value(DEFAULT_CANCEL_URL))
            .andExpect(jsonPath("$.enterprise").value(DEFAULT_ENTERPRISE))
            .andExpect(jsonPath("$.registryCode").value(DEFAULT_REGISTRY_CODE))
            .andExpect(jsonPath("$.mainRoomName").value(DEFAULT_MAIN_ROOM_NAME))
            .andExpect(jsonPath("$.subdomain").value(DEFAULT_SUBDOMAIN))
            .andExpect(jsonPath("$.menuTpv").value(DEFAULT_MENU_TPV))
            .andExpect(jsonPath("$.menuClientes").value(DEFAULT_MENU_CLIENTES))
            .andExpect(jsonPath("$.menuIntegraciones").value(DEFAULT_MENU_INTEGRACIONES))
            .andExpect(jsonPath("$.menuSalas").value(DEFAULT_MENU_SALAS))
            .andExpect(jsonPath("$.menuPerfil").value(DEFAULT_MENU_PERFIL))
            .andExpect(jsonPath("$.menuAyuda").value(DEFAULT_MENU_AYUDA))
            .andExpect(jsonPath("$.menuTaquilla").value(DEFAULT_MENU_TAQUILLA))
            .andExpect(jsonPath("$.menuAbonos").value(DEFAULT_MENU_ABONOS))
            .andExpect(jsonPath("$.menuICAA").value(DEFAULT_MENU_ICAA))
            .andExpect(jsonPath("$.disclaimers").value(DEFAULT_DISCLAIMERS))
            .andExpect(jsonPath("$.reglas").value(DEFAULT_REGLAS))
            .andExpect(jsonPath("$.usuarios").value(DEFAULT_USUARIOS))
            .andExpect(jsonPath("$.cupones").value(DEFAULT_CUPONES))
            .andExpect(jsonPath("$.ventaCruzada").value(DEFAULT_VENTA_CRUZADA))
            .andExpect(jsonPath("$.packs").value(DEFAULT_PACKS))
            .andExpect(jsonPath("$.menuTiposEvento").value(DEFAULT_MENU_TIPOS_EVENTO))
            .andExpect(jsonPath("$.menuPlantillasPrecios").value(DEFAULT_MENU_PLANTILLAS_PRECIOS))
            .andExpect(jsonPath("$.menuPlantillasReserva").value(DEFAULT_MENU_PLANTILLAS_RESERVA))
            .andExpect(jsonPath("$.menuTarifas").value(DEFAULT_MENU_TARIFAS))
            .andExpect(jsonPath("$.menuComprasReservas").value(DEFAULT_MENU_COMPRAS_RESERVAS))
            .andExpect(jsonPath("$.menuInformes").value(DEFAULT_MENU_INFORMES))
            .andExpect(jsonPath("$.menuInformesSesion").value(DEFAULT_MENU_INFORMES_SESION))
            .andExpect(jsonPath("$.thirdParty").value(DEFAULT_THIRD_PARTY))
            .andExpect(jsonPath("$.menuAforoPorDias").value(DEFAULT_MENU_AFORO_POR_DIAS))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS.toString()));
    }

    @Test
    @Transactional
    void getNonExistingCustomer() throws Exception {
        // Get the customer
        restCustomerMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingCustomer() throws Exception {
        // Initialize the database
        customerRepository.saveAndFlush(customer);

        int databaseSizeBeforeUpdate = customerRepository.findAll().size();

        // Update the customer
        Customer updatedCustomer = customerRepository.findById(customer.getId()).get();
        // Disconnect from session so that the updates on updatedCustomer are not directly saved in db
        em.detach(updatedCustomer);
        updatedCustomer
            .name(UPDATED_NAME)
            .lastName(UPDATED_LAST_NAME)
            .cif(UPDATED_CIF)
            .direction(UPDATED_DIRECTION)
            .municipality(UPDATED_MUNICIPALITY)
            .pc(UPDATED_PC)
            .telephoneNumber(UPDATED_TELEPHONE_NUMBER)
            .email(UPDATED_EMAIL)
            .privacyUrl(UPDATED_PRIVACY_URL)
            .cancelUrl(UPDATED_CANCEL_URL)
            .enterprise(UPDATED_ENTERPRISE)
            .registryCode(UPDATED_REGISTRY_CODE)
            .mainRoomName(UPDATED_MAIN_ROOM_NAME)
            .subdomain(UPDATED_SUBDOMAIN)
            .menuTpv(UPDATED_MENU_TPV)
            .menuClientes(UPDATED_MENU_CLIENTES)
            .menuIntegraciones(UPDATED_MENU_INTEGRACIONES)
            .menuSalas(UPDATED_MENU_SALAS)
            .menuPerfil(UPDATED_MENU_PERFIL)
            .menuAyuda(UPDATED_MENU_AYUDA)
            .menuTaquilla(UPDATED_MENU_TAQUILLA)
            .menuAbonos(UPDATED_MENU_ABONOS)
            .menuICAA(UPDATED_MENU_ICAA)
            .disclaimers(UPDATED_DISCLAIMERS)
            .reglas(UPDATED_REGLAS)
            .usuarios(UPDATED_USUARIOS)
            .cupones(UPDATED_CUPONES)
            .ventaCruzada(UPDATED_VENTA_CRUZADA)
            .packs(UPDATED_PACKS)
            .menuTiposEvento(UPDATED_MENU_TIPOS_EVENTO)
            .menuPlantillasPrecios(UPDATED_MENU_PLANTILLAS_PRECIOS)
            .menuPlantillasReserva(UPDATED_MENU_PLANTILLAS_RESERVA)
            .menuTarifas(UPDATED_MENU_TARIFAS)
            .menuComprasReservas(UPDATED_MENU_COMPRAS_RESERVAS)
            .menuInformes(UPDATED_MENU_INFORMES)
            .menuInformesSesion(UPDATED_MENU_INFORMES_SESION)
            .thirdParty(UPDATED_THIRD_PARTY)
            .menuAforoPorDias(UPDATED_MENU_AFORO_POR_DIAS)
            .status(UPDATED_STATUS);

        restCustomerMockMvc
            .perform(
                put(ENTITY_API_URL_ID, updatedCustomer.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(updatedCustomer))
            )
            .andExpect(status().isOk());

        // Validate the Customer in the database
        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeUpdate);
        Customer testCustomer = customerList.get(customerList.size() - 1);
        assertThat(testCustomer.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testCustomer.getLastName()).isEqualTo(UPDATED_LAST_NAME);
        assertThat(testCustomer.getCif()).isEqualTo(UPDATED_CIF);
        assertThat(testCustomer.getDirection()).isEqualTo(UPDATED_DIRECTION);
        assertThat(testCustomer.getMunicipality()).isEqualTo(UPDATED_MUNICIPALITY);
        assertThat(testCustomer.getPc()).isEqualTo(UPDATED_PC);
        assertThat(testCustomer.getTelephoneNumber()).isEqualTo(UPDATED_TELEPHONE_NUMBER);
        assertThat(testCustomer.getEmail()).isEqualTo(UPDATED_EMAIL);
        assertThat(testCustomer.getPrivacyUrl()).isEqualTo(UPDATED_PRIVACY_URL);
        assertThat(testCustomer.getCancelUrl()).isEqualTo(UPDATED_CANCEL_URL);
        assertThat(testCustomer.getEnterprise()).isEqualTo(UPDATED_ENTERPRISE);
        assertThat(testCustomer.getRegistryCode()).isEqualTo(UPDATED_REGISTRY_CODE);
        assertThat(testCustomer.getMainRoomName()).isEqualTo(UPDATED_MAIN_ROOM_NAME);
        assertThat(testCustomer.getSubdomain()).isEqualTo(UPDATED_SUBDOMAIN);
        assertThat(testCustomer.getMenuTpv()).isEqualTo(UPDATED_MENU_TPV);
        assertThat(testCustomer.getMenuClientes()).isEqualTo(UPDATED_MENU_CLIENTES);
        assertThat(testCustomer.getMenuIntegraciones()).isEqualTo(UPDATED_MENU_INTEGRACIONES);
        assertThat(testCustomer.getMenuSalas()).isEqualTo(UPDATED_MENU_SALAS);
        assertThat(testCustomer.getMenuPerfil()).isEqualTo(UPDATED_MENU_PERFIL);
        assertThat(testCustomer.getMenuAyuda()).isEqualTo(UPDATED_MENU_AYUDA);
        assertThat(testCustomer.getMenuTaquilla()).isEqualTo(UPDATED_MENU_TAQUILLA);
        assertThat(testCustomer.getMenuAbonos()).isEqualTo(UPDATED_MENU_ABONOS);
        assertThat(testCustomer.getMenuICAA()).isEqualTo(UPDATED_MENU_ICAA);
        assertThat(testCustomer.getDisclaimers()).isEqualTo(UPDATED_DISCLAIMERS);
        assertThat(testCustomer.getReglas()).isEqualTo(UPDATED_REGLAS);
        assertThat(testCustomer.getUsuarios()).isEqualTo(UPDATED_USUARIOS);
        assertThat(testCustomer.getCupones()).isEqualTo(UPDATED_CUPONES);
        assertThat(testCustomer.getVentaCruzada()).isEqualTo(UPDATED_VENTA_CRUZADA);
        assertThat(testCustomer.getPacks()).isEqualTo(UPDATED_PACKS);
        assertThat(testCustomer.getMenuTiposEvento()).isEqualTo(UPDATED_MENU_TIPOS_EVENTO);
        assertThat(testCustomer.getMenuPlantillasPrecios()).isEqualTo(UPDATED_MENU_PLANTILLAS_PRECIOS);
        assertThat(testCustomer.getMenuPlantillasReserva()).isEqualTo(UPDATED_MENU_PLANTILLAS_RESERVA);
        assertThat(testCustomer.getMenuTarifas()).isEqualTo(UPDATED_MENU_TARIFAS);
        assertThat(testCustomer.getMenuComprasReservas()).isEqualTo(UPDATED_MENU_COMPRAS_RESERVAS);
        assertThat(testCustomer.getMenuInformes()).isEqualTo(UPDATED_MENU_INFORMES);
        assertThat(testCustomer.getMenuInformesSesion()).isEqualTo(UPDATED_MENU_INFORMES_SESION);
        assertThat(testCustomer.getThirdParty()).isEqualTo(UPDATED_THIRD_PARTY);
        assertThat(testCustomer.getMenuAforoPorDias()).isEqualTo(UPDATED_MENU_AFORO_POR_DIAS);
        assertThat(testCustomer.getStatus()).isEqualTo(UPDATED_STATUS);
    }

    @Test
    @Transactional
    void putNonExistingCustomer() throws Exception {
        int databaseSizeBeforeUpdate = customerRepository.findAll().size();
        customer.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCustomerMockMvc
            .perform(
                put(ENTITY_API_URL_ID, customer.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(customer))
            )
            .andExpect(status().isBadRequest());

        // Validate the Customer in the database
        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchCustomer() throws Exception {
        int databaseSizeBeforeUpdate = customerRepository.findAll().size();
        customer.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restCustomerMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(customer))
            )
            .andExpect(status().isBadRequest());

        // Validate the Customer in the database
        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamCustomer() throws Exception {
        int databaseSizeBeforeUpdate = customerRepository.findAll().size();
        customer.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restCustomerMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Customer in the database
        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateCustomerWithPatch() throws Exception {
        // Initialize the database
        customerRepository.saveAndFlush(customer);

        int databaseSizeBeforeUpdate = customerRepository.findAll().size();

        // Update the customer using partial update
        Customer partialUpdatedCustomer = new Customer();
        partialUpdatedCustomer.setId(customer.getId());

        partialUpdatedCustomer
            .name(UPDATED_NAME)
            .municipality(UPDATED_MUNICIPALITY)
            .email(UPDATED_EMAIL)
            .privacyUrl(UPDATED_PRIVACY_URL)
            .mainRoomName(UPDATED_MAIN_ROOM_NAME)
            .menuClientes(UPDATED_MENU_CLIENTES)
            .menuSalas(UPDATED_MENU_SALAS)
            .menuTaquilla(UPDATED_MENU_TAQUILLA)
            .usuarios(UPDATED_USUARIOS)
            .ventaCruzada(UPDATED_VENTA_CRUZADA)
            .packs(UPDATED_PACKS)
            .menuTiposEvento(UPDATED_MENU_TIPOS_EVENTO)
            .menuPlantillasReserva(UPDATED_MENU_PLANTILLAS_RESERVA)
            .menuInformes(UPDATED_MENU_INFORMES)
            .menuInformesSesion(UPDATED_MENU_INFORMES_SESION)
            .thirdParty(UPDATED_THIRD_PARTY)
            .menuAforoPorDias(UPDATED_MENU_AFORO_POR_DIAS)
            .status(UPDATED_STATUS);

        restCustomerMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedCustomer.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedCustomer))
            )
            .andExpect(status().isOk());

        // Validate the Customer in the database
        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeUpdate);
        Customer testCustomer = customerList.get(customerList.size() - 1);
        assertThat(testCustomer.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testCustomer.getLastName()).isEqualTo(DEFAULT_LAST_NAME);
        assertThat(testCustomer.getCif()).isEqualTo(DEFAULT_CIF);
        assertThat(testCustomer.getDirection()).isEqualTo(DEFAULT_DIRECTION);
        assertThat(testCustomer.getMunicipality()).isEqualTo(UPDATED_MUNICIPALITY);
        assertThat(testCustomer.getPc()).isEqualTo(DEFAULT_PC);
        assertThat(testCustomer.getTelephoneNumber()).isEqualTo(DEFAULT_TELEPHONE_NUMBER);
        assertThat(testCustomer.getEmail()).isEqualTo(UPDATED_EMAIL);
        assertThat(testCustomer.getPrivacyUrl()).isEqualTo(UPDATED_PRIVACY_URL);
        assertThat(testCustomer.getCancelUrl()).isEqualTo(DEFAULT_CANCEL_URL);
        assertThat(testCustomer.getEnterprise()).isEqualTo(DEFAULT_ENTERPRISE);
        assertThat(testCustomer.getRegistryCode()).isEqualTo(DEFAULT_REGISTRY_CODE);
        assertThat(testCustomer.getMainRoomName()).isEqualTo(UPDATED_MAIN_ROOM_NAME);
        assertThat(testCustomer.getSubdomain()).isEqualTo(DEFAULT_SUBDOMAIN);
        assertThat(testCustomer.getMenuTpv()).isEqualTo(DEFAULT_MENU_TPV);
        assertThat(testCustomer.getMenuClientes()).isEqualTo(UPDATED_MENU_CLIENTES);
        assertThat(testCustomer.getMenuIntegraciones()).isEqualTo(DEFAULT_MENU_INTEGRACIONES);
        assertThat(testCustomer.getMenuSalas()).isEqualTo(UPDATED_MENU_SALAS);
        assertThat(testCustomer.getMenuPerfil()).isEqualTo(DEFAULT_MENU_PERFIL);
        assertThat(testCustomer.getMenuAyuda()).isEqualTo(DEFAULT_MENU_AYUDA);
        assertThat(testCustomer.getMenuTaquilla()).isEqualTo(UPDATED_MENU_TAQUILLA);
        assertThat(testCustomer.getMenuAbonos()).isEqualTo(DEFAULT_MENU_ABONOS);
        assertThat(testCustomer.getMenuICAA()).isEqualTo(DEFAULT_MENU_ICAA);
        assertThat(testCustomer.getDisclaimers()).isEqualTo(DEFAULT_DISCLAIMERS);
        assertThat(testCustomer.getReglas()).isEqualTo(DEFAULT_REGLAS);
        assertThat(testCustomer.getUsuarios()).isEqualTo(UPDATED_USUARIOS);
        assertThat(testCustomer.getCupones()).isEqualTo(DEFAULT_CUPONES);
        assertThat(testCustomer.getVentaCruzada()).isEqualTo(UPDATED_VENTA_CRUZADA);
        assertThat(testCustomer.getPacks()).isEqualTo(UPDATED_PACKS);
        assertThat(testCustomer.getMenuTiposEvento()).isEqualTo(UPDATED_MENU_TIPOS_EVENTO);
        assertThat(testCustomer.getMenuPlantillasPrecios()).isEqualTo(DEFAULT_MENU_PLANTILLAS_PRECIOS);
        assertThat(testCustomer.getMenuPlantillasReserva()).isEqualTo(UPDATED_MENU_PLANTILLAS_RESERVA);
        assertThat(testCustomer.getMenuTarifas()).isEqualTo(DEFAULT_MENU_TARIFAS);
        assertThat(testCustomer.getMenuComprasReservas()).isEqualTo(DEFAULT_MENU_COMPRAS_RESERVAS);
        assertThat(testCustomer.getMenuInformes()).isEqualTo(UPDATED_MENU_INFORMES);
        assertThat(testCustomer.getMenuInformesSesion()).isEqualTo(UPDATED_MENU_INFORMES_SESION);
        assertThat(testCustomer.getThirdParty()).isEqualTo(UPDATED_THIRD_PARTY);
        assertThat(testCustomer.getMenuAforoPorDias()).isEqualTo(UPDATED_MENU_AFORO_POR_DIAS);
        assertThat(testCustomer.getStatus()).isEqualTo(UPDATED_STATUS);
    }

    @Test
    @Transactional
    void fullUpdateCustomerWithPatch() throws Exception {
        // Initialize the database
        customerRepository.saveAndFlush(customer);

        int databaseSizeBeforeUpdate = customerRepository.findAll().size();

        // Update the customer using partial update
        Customer partialUpdatedCustomer = new Customer();
        partialUpdatedCustomer.setId(customer.getId());

        partialUpdatedCustomer
            .name(UPDATED_NAME)
            .lastName(UPDATED_LAST_NAME)
            .cif(UPDATED_CIF)
            .direction(UPDATED_DIRECTION)
            .municipality(UPDATED_MUNICIPALITY)
            .pc(UPDATED_PC)
            .telephoneNumber(UPDATED_TELEPHONE_NUMBER)
            .email(UPDATED_EMAIL)
            .privacyUrl(UPDATED_PRIVACY_URL)
            .cancelUrl(UPDATED_CANCEL_URL)
            .enterprise(UPDATED_ENTERPRISE)
            .registryCode(UPDATED_REGISTRY_CODE)
            .mainRoomName(UPDATED_MAIN_ROOM_NAME)
            .subdomain(UPDATED_SUBDOMAIN)
            .menuTpv(UPDATED_MENU_TPV)
            .menuClientes(UPDATED_MENU_CLIENTES)
            .menuIntegraciones(UPDATED_MENU_INTEGRACIONES)
            .menuSalas(UPDATED_MENU_SALAS)
            .menuPerfil(UPDATED_MENU_PERFIL)
            .menuAyuda(UPDATED_MENU_AYUDA)
            .menuTaquilla(UPDATED_MENU_TAQUILLA)
            .menuAbonos(UPDATED_MENU_ABONOS)
            .menuICAA(UPDATED_MENU_ICAA)
            .disclaimers(UPDATED_DISCLAIMERS)
            .reglas(UPDATED_REGLAS)
            .usuarios(UPDATED_USUARIOS)
            .cupones(UPDATED_CUPONES)
            .ventaCruzada(UPDATED_VENTA_CRUZADA)
            .packs(UPDATED_PACKS)
            .menuTiposEvento(UPDATED_MENU_TIPOS_EVENTO)
            .menuPlantillasPrecios(UPDATED_MENU_PLANTILLAS_PRECIOS)
            .menuPlantillasReserva(UPDATED_MENU_PLANTILLAS_RESERVA)
            .menuTarifas(UPDATED_MENU_TARIFAS)
            .menuComprasReservas(UPDATED_MENU_COMPRAS_RESERVAS)
            .menuInformes(UPDATED_MENU_INFORMES)
            .menuInformesSesion(UPDATED_MENU_INFORMES_SESION)
            .thirdParty(UPDATED_THIRD_PARTY)
            .menuAforoPorDias(UPDATED_MENU_AFORO_POR_DIAS)
            .status(UPDATED_STATUS);

        restCustomerMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedCustomer.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedCustomer))
            )
            .andExpect(status().isOk());

        // Validate the Customer in the database
        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeUpdate);
        Customer testCustomer = customerList.get(customerList.size() - 1);
        assertThat(testCustomer.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testCustomer.getLastName()).isEqualTo(UPDATED_LAST_NAME);
        assertThat(testCustomer.getCif()).isEqualTo(UPDATED_CIF);
        assertThat(testCustomer.getDirection()).isEqualTo(UPDATED_DIRECTION);
        assertThat(testCustomer.getMunicipality()).isEqualTo(UPDATED_MUNICIPALITY);
        assertThat(testCustomer.getPc()).isEqualTo(UPDATED_PC);
        assertThat(testCustomer.getTelephoneNumber()).isEqualTo(UPDATED_TELEPHONE_NUMBER);
        assertThat(testCustomer.getEmail()).isEqualTo(UPDATED_EMAIL);
        assertThat(testCustomer.getPrivacyUrl()).isEqualTo(UPDATED_PRIVACY_URL);
        assertThat(testCustomer.getCancelUrl()).isEqualTo(UPDATED_CANCEL_URL);
        assertThat(testCustomer.getEnterprise()).isEqualTo(UPDATED_ENTERPRISE);
        assertThat(testCustomer.getRegistryCode()).isEqualTo(UPDATED_REGISTRY_CODE);
        assertThat(testCustomer.getMainRoomName()).isEqualTo(UPDATED_MAIN_ROOM_NAME);
        assertThat(testCustomer.getSubdomain()).isEqualTo(UPDATED_SUBDOMAIN);
        assertThat(testCustomer.getMenuTpv()).isEqualTo(UPDATED_MENU_TPV);
        assertThat(testCustomer.getMenuClientes()).isEqualTo(UPDATED_MENU_CLIENTES);
        assertThat(testCustomer.getMenuIntegraciones()).isEqualTo(UPDATED_MENU_INTEGRACIONES);
        assertThat(testCustomer.getMenuSalas()).isEqualTo(UPDATED_MENU_SALAS);
        assertThat(testCustomer.getMenuPerfil()).isEqualTo(UPDATED_MENU_PERFIL);
        assertThat(testCustomer.getMenuAyuda()).isEqualTo(UPDATED_MENU_AYUDA);
        assertThat(testCustomer.getMenuTaquilla()).isEqualTo(UPDATED_MENU_TAQUILLA);
        assertThat(testCustomer.getMenuAbonos()).isEqualTo(UPDATED_MENU_ABONOS);
        assertThat(testCustomer.getMenuICAA()).isEqualTo(UPDATED_MENU_ICAA);
        assertThat(testCustomer.getDisclaimers()).isEqualTo(UPDATED_DISCLAIMERS);
        assertThat(testCustomer.getReglas()).isEqualTo(UPDATED_REGLAS);
        assertThat(testCustomer.getUsuarios()).isEqualTo(UPDATED_USUARIOS);
        assertThat(testCustomer.getCupones()).isEqualTo(UPDATED_CUPONES);
        assertThat(testCustomer.getVentaCruzada()).isEqualTo(UPDATED_VENTA_CRUZADA);
        assertThat(testCustomer.getPacks()).isEqualTo(UPDATED_PACKS);
        assertThat(testCustomer.getMenuTiposEvento()).isEqualTo(UPDATED_MENU_TIPOS_EVENTO);
        assertThat(testCustomer.getMenuPlantillasPrecios()).isEqualTo(UPDATED_MENU_PLANTILLAS_PRECIOS);
        assertThat(testCustomer.getMenuPlantillasReserva()).isEqualTo(UPDATED_MENU_PLANTILLAS_RESERVA);
        assertThat(testCustomer.getMenuTarifas()).isEqualTo(UPDATED_MENU_TARIFAS);
        assertThat(testCustomer.getMenuComprasReservas()).isEqualTo(UPDATED_MENU_COMPRAS_RESERVAS);
        assertThat(testCustomer.getMenuInformes()).isEqualTo(UPDATED_MENU_INFORMES);
        assertThat(testCustomer.getMenuInformesSesion()).isEqualTo(UPDATED_MENU_INFORMES_SESION);
        assertThat(testCustomer.getThirdParty()).isEqualTo(UPDATED_THIRD_PARTY);
        assertThat(testCustomer.getMenuAforoPorDias()).isEqualTo(UPDATED_MENU_AFORO_POR_DIAS);
        assertThat(testCustomer.getStatus()).isEqualTo(UPDATED_STATUS);
    }

    @Test
    @Transactional
    void patchNonExistingCustomer() throws Exception {
        int databaseSizeBeforeUpdate = customerRepository.findAll().size();
        customer.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCustomerMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, customer.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(customer))
            )
            .andExpect(status().isBadRequest());

        // Validate the Customer in the database
        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchCustomer() throws Exception {
        int databaseSizeBeforeUpdate = customerRepository.findAll().size();
        customer.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restCustomerMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(customer))
            )
            .andExpect(status().isBadRequest());

        // Validate the Customer in the database
        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamCustomer() throws Exception {
        int databaseSizeBeforeUpdate = customerRepository.findAll().size();
        customer.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restCustomerMockMvc
            .perform(patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(customer)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Customer in the database
        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteCustomer() throws Exception {
        // Initialize the database
        customerRepository.saveAndFlush(customer);

        int databaseSizeBeforeDelete = customerRepository.findAll().size();

        // Delete the customer
        restCustomerMockMvc
            .perform(delete(ENTITY_API_URL_ID, customer.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
