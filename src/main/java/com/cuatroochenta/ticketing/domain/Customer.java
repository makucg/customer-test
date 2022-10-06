package com.cuatroochenta.ticketing.domain;

import com.cuatroochenta.ticketing.domain.enumeration.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A Customer.
 */
@Entity
@Table(name = "customer")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotNull
    @Column(name = "cif", nullable = false)
    private String cif;

    @NotNull
    @Column(name = "direction", nullable = false)
    private String direction;

    @NotNull
    @Column(name = "municipality", nullable = false)
    private String municipality;

    @NotNull
    @Column(name = "pc", nullable = false)
    private String pc;

    @NotNull
    @Column(name = "telephone_number", nullable = false)
    private String telephoneNumber;

    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull
    @Column(name = "privacy_url", nullable = false)
    private String privacyUrl;

    @NotNull
    @Column(name = "cancel_url", nullable = false)
    private String cancelUrl;

    @NotNull
    @Column(name = "enterprise", nullable = false)
    private String enterprise;

    @NotNull
    @Column(name = "registry_code", nullable = false)
    private String registryCode;

    @NotNull
    @Column(name = "main_room_name", nullable = false)
    private String mainRoomName;

    @NotNull
    @Column(name = "subdomain", nullable = false)
    private String subdomain;

    @NotNull
    @Column(name = "menu_tpv", nullable = false)
    private String menuTpv;

    @NotNull
    @Column(name = "menu_clientes", nullable = false)
    private String menuClientes;

    @NotNull
    @Column(name = "menu_integraciones", nullable = false)
    private String menuIntegraciones;

    @NotNull
    @Column(name = "menu_salas", nullable = false)
    private String menuSalas;

    @NotNull
    @Column(name = "menu_perfil", nullable = false)
    private String menuPerfil;

    @NotNull
    @Column(name = "menu_ayuda", nullable = false)
    private String menuAyuda;

    @NotNull
    @Column(name = "menu_taquilla", nullable = false)
    private String menuTaquilla;

    @NotNull
    @Column(name = "menu_abonos", nullable = false)
    private String menuAbonos;

    @NotNull
    @Column(name = "menu_icaa", nullable = false)
    private String menuICAA;

    @NotNull
    @Column(name = "disclaimers", nullable = false)
    private String disclaimers;

    @NotNull
    @Column(name = "reglas", nullable = false)
    private String reglas;

    @NotNull
    @Column(name = "usuarios", nullable = false)
    private String usuarios;

    @NotNull
    @Column(name = "cupones", nullable = false)
    private String cupones;

    @NotNull
    @Column(name = "venta_cruzada", nullable = false)
    private String ventaCruzada;

    @NotNull
    @Column(name = "packs", nullable = false)
    private String packs;

    @NotNull
    @Column(name = "menu_tipos_evento", nullable = false)
    private String menuTiposEvento;

    @NotNull
    @Column(name = "menu_plantillas_precios", nullable = false)
    private String menuPlantillasPrecios;

    @NotNull
    @Column(name = "menu_plantillas_reserva", nullable = false)
    private String menuPlantillasReserva;

    @NotNull
    @Column(name = "menu_tarifas", nullable = false)
    private String menuTarifas;

    @NotNull
    @Column(name = "menu_compras_reservas", nullable = false)
    private String menuComprasReservas;

    @NotNull
    @Column(name = "menu_informes", nullable = false)
    private String menuInformes;

    @NotNull
    @Column(name = "menu_informes_sesion", nullable = false)
    private String menuInformesSesion;

    @NotNull
    @Column(name = "third_party", nullable = false)
    private String thirdParty;

    @NotNull
    @Column(name = "menu_aforo_por_dias", nullable = false)
    private String menuAforoPorDias;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @OneToMany(mappedBy = "customer")
    @JsonIgnoreProperties(value = { "customer" }, allowSetters = true)
    private Set<Language> languages = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Customer id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public Customer name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Customer lastName(String lastName) {
        this.setLastName(lastName);
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCif() {
        return this.cif;
    }

    public Customer cif(String cif) {
        this.setCif(cif);
        return this;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getDirection() {
        return this.direction;
    }

    public Customer direction(String direction) {
        this.setDirection(direction);
        return this;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getMunicipality() {
        return this.municipality;
    }

    public Customer municipality(String municipality) {
        this.setMunicipality(municipality);
        return this;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getPc() {
        return this.pc;
    }

    public Customer pc(String pc) {
        this.setPc(pc);
        return this;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public String getTelephoneNumber() {
        return this.telephoneNumber;
    }

    public Customer telephoneNumber(String telephoneNumber) {
        this.setTelephoneNumber(telephoneNumber);
        return this;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public Customer email(String email) {
        this.setEmail(email);
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrivacyUrl() {
        return this.privacyUrl;
    }

    public Customer privacyUrl(String privacyUrl) {
        this.setPrivacyUrl(privacyUrl);
        return this;
    }

    public void setPrivacyUrl(String privacyUrl) {
        this.privacyUrl = privacyUrl;
    }

    public String getCancelUrl() {
        return this.cancelUrl;
    }

    public Customer cancelUrl(String cancelUrl) {
        this.setCancelUrl(cancelUrl);
        return this;
    }

    public void setCancelUrl(String cancelUrl) {
        this.cancelUrl = cancelUrl;
    }

    public String getEnterprise() {
        return this.enterprise;
    }

    public Customer enterprise(String enterprise) {
        this.setEnterprise(enterprise);
        return this;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public String getRegistryCode() {
        return this.registryCode;
    }

    public Customer registryCode(String registryCode) {
        this.setRegistryCode(registryCode);
        return this;
    }

    public void setRegistryCode(String registryCode) {
        this.registryCode = registryCode;
    }

    public String getMainRoomName() {
        return this.mainRoomName;
    }

    public Customer mainRoomName(String mainRoomName) {
        this.setMainRoomName(mainRoomName);
        return this;
    }

    public void setMainRoomName(String mainRoomName) {
        this.mainRoomName = mainRoomName;
    }

    public String getSubdomain() {
        return this.subdomain;
    }

    public Customer subdomain(String subdomain) {
        this.setSubdomain(subdomain);
        return this;
    }

    public void setSubdomain(String subdomain) {
        this.subdomain = subdomain;
    }

    public String getMenuTpv() {
        return this.menuTpv;
    }

    public Customer menuTpv(String menuTpv) {
        this.setMenuTpv(menuTpv);
        return this;
    }

    public void setMenuTpv(String menuTpv) {
        this.menuTpv = menuTpv;
    }

    public String getMenuClientes() {
        return this.menuClientes;
    }

    public Customer menuClientes(String menuClientes) {
        this.setMenuClientes(menuClientes);
        return this;
    }

    public void setMenuClientes(String menuClientes) {
        this.menuClientes = menuClientes;
    }

    public String getMenuIntegraciones() {
        return this.menuIntegraciones;
    }

    public Customer menuIntegraciones(String menuIntegraciones) {
        this.setMenuIntegraciones(menuIntegraciones);
        return this;
    }

    public void setMenuIntegraciones(String menuIntegraciones) {
        this.menuIntegraciones = menuIntegraciones;
    }

    public String getMenuSalas() {
        return this.menuSalas;
    }

    public Customer menuSalas(String menuSalas) {
        this.setMenuSalas(menuSalas);
        return this;
    }

    public void setMenuSalas(String menuSalas) {
        this.menuSalas = menuSalas;
    }

    public String getMenuPerfil() {
        return this.menuPerfil;
    }

    public Customer menuPerfil(String menuPerfil) {
        this.setMenuPerfil(menuPerfil);
        return this;
    }

    public void setMenuPerfil(String menuPerfil) {
        this.menuPerfil = menuPerfil;
    }

    public String getMenuAyuda() {
        return this.menuAyuda;
    }

    public Customer menuAyuda(String menuAyuda) {
        this.setMenuAyuda(menuAyuda);
        return this;
    }

    public void setMenuAyuda(String menuAyuda) {
        this.menuAyuda = menuAyuda;
    }

    public String getMenuTaquilla() {
        return this.menuTaquilla;
    }

    public Customer menuTaquilla(String menuTaquilla) {
        this.setMenuTaquilla(menuTaquilla);
        return this;
    }

    public void setMenuTaquilla(String menuTaquilla) {
        this.menuTaquilla = menuTaquilla;
    }

    public String getMenuAbonos() {
        return this.menuAbonos;
    }

    public Customer menuAbonos(String menuAbonos) {
        this.setMenuAbonos(menuAbonos);
        return this;
    }

    public void setMenuAbonos(String menuAbonos) {
        this.menuAbonos = menuAbonos;
    }

    public String getMenuICAA() {
        return this.menuICAA;
    }

    public Customer menuICAA(String menuICAA) {
        this.setMenuICAA(menuICAA);
        return this;
    }

    public void setMenuICAA(String menuICAA) {
        this.menuICAA = menuICAA;
    }

    public String getDisclaimers() {
        return this.disclaimers;
    }

    public Customer disclaimers(String disclaimers) {
        this.setDisclaimers(disclaimers);
        return this;
    }

    public void setDisclaimers(String disclaimers) {
        this.disclaimers = disclaimers;
    }

    public String getReglas() {
        return this.reglas;
    }

    public Customer reglas(String reglas) {
        this.setReglas(reglas);
        return this;
    }

    public void setReglas(String reglas) {
        this.reglas = reglas;
    }

    public String getUsuarios() {
        return this.usuarios;
    }

    public Customer usuarios(String usuarios) {
        this.setUsuarios(usuarios);
        return this;
    }

    public void setUsuarios(String usuarios) {
        this.usuarios = usuarios;
    }

    public String getCupones() {
        return this.cupones;
    }

    public Customer cupones(String cupones) {
        this.setCupones(cupones);
        return this;
    }

    public void setCupones(String cupones) {
        this.cupones = cupones;
    }

    public String getVentaCruzada() {
        return this.ventaCruzada;
    }

    public Customer ventaCruzada(String ventaCruzada) {
        this.setVentaCruzada(ventaCruzada);
        return this;
    }

    public void setVentaCruzada(String ventaCruzada) {
        this.ventaCruzada = ventaCruzada;
    }

    public String getPacks() {
        return this.packs;
    }

    public Customer packs(String packs) {
        this.setPacks(packs);
        return this;
    }

    public void setPacks(String packs) {
        this.packs = packs;
    }

    public String getMenuTiposEvento() {
        return this.menuTiposEvento;
    }

    public Customer menuTiposEvento(String menuTiposEvento) {
        this.setMenuTiposEvento(menuTiposEvento);
        return this;
    }

    public void setMenuTiposEvento(String menuTiposEvento) {
        this.menuTiposEvento = menuTiposEvento;
    }

    public String getMenuPlantillasPrecios() {
        return this.menuPlantillasPrecios;
    }

    public Customer menuPlantillasPrecios(String menuPlantillasPrecios) {
        this.setMenuPlantillasPrecios(menuPlantillasPrecios);
        return this;
    }

    public void setMenuPlantillasPrecios(String menuPlantillasPrecios) {
        this.menuPlantillasPrecios = menuPlantillasPrecios;
    }

    public String getMenuPlantillasReserva() {
        return this.menuPlantillasReserva;
    }

    public Customer menuPlantillasReserva(String menuPlantillasReserva) {
        this.setMenuPlantillasReserva(menuPlantillasReserva);
        return this;
    }

    public void setMenuPlantillasReserva(String menuPlantillasReserva) {
        this.menuPlantillasReserva = menuPlantillasReserva;
    }

    public String getMenuTarifas() {
        return this.menuTarifas;
    }

    public Customer menuTarifas(String menuTarifas) {
        this.setMenuTarifas(menuTarifas);
        return this;
    }

    public void setMenuTarifas(String menuTarifas) {
        this.menuTarifas = menuTarifas;
    }

    public String getMenuComprasReservas() {
        return this.menuComprasReservas;
    }

    public Customer menuComprasReservas(String menuComprasReservas) {
        this.setMenuComprasReservas(menuComprasReservas);
        return this;
    }

    public void setMenuComprasReservas(String menuComprasReservas) {
        this.menuComprasReservas = menuComprasReservas;
    }

    public String getMenuInformes() {
        return this.menuInformes;
    }

    public Customer menuInformes(String menuInformes) {
        this.setMenuInformes(menuInformes);
        return this;
    }

    public void setMenuInformes(String menuInformes) {
        this.menuInformes = menuInformes;
    }

    public String getMenuInformesSesion() {
        return this.menuInformesSesion;
    }

    public Customer menuInformesSesion(String menuInformesSesion) {
        this.setMenuInformesSesion(menuInformesSesion);
        return this;
    }

    public void setMenuInformesSesion(String menuInformesSesion) {
        this.menuInformesSesion = menuInformesSesion;
    }

    public String getThirdParty() {
        return this.thirdParty;
    }

    public Customer thirdParty(String thirdParty) {
        this.setThirdParty(thirdParty);
        return this;
    }

    public void setThirdParty(String thirdParty) {
        this.thirdParty = thirdParty;
    }

    public String getMenuAforoPorDias() {
        return this.menuAforoPorDias;
    }

    public Customer menuAforoPorDias(String menuAforoPorDias) {
        this.setMenuAforoPorDias(menuAforoPorDias);
        return this;
    }

    public void setMenuAforoPorDias(String menuAforoPorDias) {
        this.menuAforoPorDias = menuAforoPorDias;
    }

    public Status getStatus() {
        return this.status;
    }

    public Customer status(Status status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<Language> getLanguages() {
        return this.languages;
    }

    public void setLanguages(Set<Language> languages) {
        if (this.languages != null) {
            this.languages.forEach(i -> i.setCustomer(null));
        }
        if (languages != null) {
            languages.forEach(i -> i.setCustomer(this));
        }
        this.languages = languages;
    }

    public Customer languages(Set<Language> languages) {
        this.setLanguages(languages);
        return this;
    }

    public Customer addLanguage(Language language) {
        this.languages.add(language);
        language.setCustomer(this);
        return this;
    }

    public Customer removeLanguage(Language language) {
        this.languages.remove(language);
        language.setCustomer(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Customer)) {
            return false;
        }
        return id != null && id.equals(((Customer) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Customer{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", cif='" + getCif() + "'" +
            ", direction='" + getDirection() + "'" +
            ", municipality='" + getMunicipality() + "'" +
            ", pc='" + getPc() + "'" +
            ", telephoneNumber='" + getTelephoneNumber() + "'" +
            ", email='" + getEmail() + "'" +
            ", privacyUrl='" + getPrivacyUrl() + "'" +
            ", cancelUrl='" + getCancelUrl() + "'" +
            ", enterprise='" + getEnterprise() + "'" +
            ", registryCode='" + getRegistryCode() + "'" +
            ", mainRoomName='" + getMainRoomName() + "'" +
            ", subdomain='" + getSubdomain() + "'" +
            ", menuTpv='" + getMenuTpv() + "'" +
            ", menuClientes='" + getMenuClientes() + "'" +
            ", menuIntegraciones='" + getMenuIntegraciones() + "'" +
            ", menuSalas='" + getMenuSalas() + "'" +
            ", menuPerfil='" + getMenuPerfil() + "'" +
            ", menuAyuda='" + getMenuAyuda() + "'" +
            ", menuTaquilla='" + getMenuTaquilla() + "'" +
            ", menuAbonos='" + getMenuAbonos() + "'" +
            ", menuICAA='" + getMenuICAA() + "'" +
            ", disclaimers='" + getDisclaimers() + "'" +
            ", reglas='" + getReglas() + "'" +
            ", usuarios='" + getUsuarios() + "'" +
            ", cupones='" + getCupones() + "'" +
            ", ventaCruzada='" + getVentaCruzada() + "'" +
            ", packs='" + getPacks() + "'" +
            ", menuTiposEvento='" + getMenuTiposEvento() + "'" +
            ", menuPlantillasPrecios='" + getMenuPlantillasPrecios() + "'" +
            ", menuPlantillasReserva='" + getMenuPlantillasReserva() + "'" +
            ", menuTarifas='" + getMenuTarifas() + "'" +
            ", menuComprasReservas='" + getMenuComprasReservas() + "'" +
            ", menuInformes='" + getMenuInformes() + "'" +
            ", menuInformesSesion='" + getMenuInformesSesion() + "'" +
            ", thirdParty='" + getThirdParty() + "'" +
            ", menuAforoPorDias='" + getMenuAforoPorDias() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
