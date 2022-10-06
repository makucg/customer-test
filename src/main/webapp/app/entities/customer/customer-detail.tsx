import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './customer.reducer';

export const CustomerDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const customerEntity = useAppSelector(state => state.customer.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="customerDetailsHeading">
          <Translate contentKey="customerTestApp.customer.detail.title">Customer</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="global.field.id">ID</Translate>
            </span>
          </dt>
          <dd>{customerEntity.id}</dd>
          <dt>
            <span id="name">
              <Translate contentKey="customerTestApp.customer.name">Name</Translate>
            </span>
          </dt>
          <dd>{customerEntity.name}</dd>
          <dt>
            <span id="lastName">
              <Translate contentKey="customerTestApp.customer.lastName">Last Name</Translate>
            </span>
          </dt>
          <dd>{customerEntity.lastName}</dd>
          <dt>
            <span id="cif">
              <Translate contentKey="customerTestApp.customer.cif">Cif</Translate>
            </span>
          </dt>
          <dd>{customerEntity.cif}</dd>
          <dt>
            <span id="direction">
              <Translate contentKey="customerTestApp.customer.direction">Direction</Translate>
            </span>
          </dt>
          <dd>{customerEntity.direction}</dd>
          <dt>
            <span id="municipality">
              <Translate contentKey="customerTestApp.customer.municipality">Municipality</Translate>
            </span>
          </dt>
          <dd>{customerEntity.municipality}</dd>
          <dt>
            <span id="pc">
              <Translate contentKey="customerTestApp.customer.pc">Pc</Translate>
            </span>
          </dt>
          <dd>{customerEntity.pc}</dd>
          <dt>
            <span id="telephoneNumber">
              <Translate contentKey="customerTestApp.customer.telephoneNumber">Telephone Number</Translate>
            </span>
          </dt>
          <dd>{customerEntity.telephoneNumber}</dd>
          <dt>
            <span id="email">
              <Translate contentKey="customerTestApp.customer.email">Email</Translate>
            </span>
          </dt>
          <dd>{customerEntity.email}</dd>
          <dt>
            <span id="privacyUrl">
              <Translate contentKey="customerTestApp.customer.privacyUrl">Privacy Url</Translate>
            </span>
          </dt>
          <dd>{customerEntity.privacyUrl}</dd>
          <dt>
            <span id="cancelUrl">
              <Translate contentKey="customerTestApp.customer.cancelUrl">Cancel Url</Translate>
            </span>
          </dt>
          <dd>{customerEntity.cancelUrl}</dd>
          <dt>
            <span id="enterprise">
              <Translate contentKey="customerTestApp.customer.enterprise">Enterprise</Translate>
            </span>
          </dt>
          <dd>{customerEntity.enterprise}</dd>
          <dt>
            <span id="registryCode">
              <Translate contentKey="customerTestApp.customer.registryCode">Registry Code</Translate>
            </span>
          </dt>
          <dd>{customerEntity.registryCode}</dd>
          <dt>
            <span id="mainRoomName">
              <Translate contentKey="customerTestApp.customer.mainRoomName">Main Room Name</Translate>
            </span>
          </dt>
          <dd>{customerEntity.mainRoomName}</dd>
          <dt>
            <span id="subdomain">
              <Translate contentKey="customerTestApp.customer.subdomain">Subdomain</Translate>
            </span>
          </dt>
          <dd>{customerEntity.subdomain}</dd>
          <dt>
            <span id="menuTpv">
              <Translate contentKey="customerTestApp.customer.menuTpv">Menu Tpv</Translate>
            </span>
          </dt>
          <dd>{customerEntity.menuTpv}</dd>
          <dt>
            <span id="menuClientes">
              <Translate contentKey="customerTestApp.customer.menuClientes">Menu Clientes</Translate>
            </span>
          </dt>
          <dd>{customerEntity.menuClientes}</dd>
          <dt>
            <span id="menuIntegraciones">
              <Translate contentKey="customerTestApp.customer.menuIntegraciones">Menu Integraciones</Translate>
            </span>
          </dt>
          <dd>{customerEntity.menuIntegraciones}</dd>
          <dt>
            <span id="menuSalas">
              <Translate contentKey="customerTestApp.customer.menuSalas">Menu Salas</Translate>
            </span>
          </dt>
          <dd>{customerEntity.menuSalas}</dd>
          <dt>
            <span id="menuPerfil">
              <Translate contentKey="customerTestApp.customer.menuPerfil">Menu Perfil</Translate>
            </span>
          </dt>
          <dd>{customerEntity.menuPerfil}</dd>
          <dt>
            <span id="menuAyuda">
              <Translate contentKey="customerTestApp.customer.menuAyuda">Menu Ayuda</Translate>
            </span>
          </dt>
          <dd>{customerEntity.menuAyuda}</dd>
          <dt>
            <span id="menuTaquilla">
              <Translate contentKey="customerTestApp.customer.menuTaquilla">Menu Taquilla</Translate>
            </span>
          </dt>
          <dd>{customerEntity.menuTaquilla}</dd>
          <dt>
            <span id="menuAbonos">
              <Translate contentKey="customerTestApp.customer.menuAbonos">Menu Abonos</Translate>
            </span>
          </dt>
          <dd>{customerEntity.menuAbonos}</dd>
          <dt>
            <span id="menuICAA">
              <Translate contentKey="customerTestApp.customer.menuICAA">Menu ICAA</Translate>
            </span>
          </dt>
          <dd>{customerEntity.menuICAA}</dd>
          <dt>
            <span id="disclaimers">
              <Translate contentKey="customerTestApp.customer.disclaimers">Disclaimers</Translate>
            </span>
          </dt>
          <dd>{customerEntity.disclaimers}</dd>
          <dt>
            <span id="reglas">
              <Translate contentKey="customerTestApp.customer.reglas">Reglas</Translate>
            </span>
          </dt>
          <dd>{customerEntity.reglas}</dd>
          <dt>
            <span id="usuarios">
              <Translate contentKey="customerTestApp.customer.usuarios">Usuarios</Translate>
            </span>
          </dt>
          <dd>{customerEntity.usuarios}</dd>
          <dt>
            <span id="cupones">
              <Translate contentKey="customerTestApp.customer.cupones">Cupones</Translate>
            </span>
          </dt>
          <dd>{customerEntity.cupones}</dd>
          <dt>
            <span id="ventaCruzada">
              <Translate contentKey="customerTestApp.customer.ventaCruzada">Venta Cruzada</Translate>
            </span>
          </dt>
          <dd>{customerEntity.ventaCruzada}</dd>
          <dt>
            <span id="packs">
              <Translate contentKey="customerTestApp.customer.packs">Packs</Translate>
            </span>
          </dt>
          <dd>{customerEntity.packs}</dd>
          <dt>
            <span id="menuTiposEvento">
              <Translate contentKey="customerTestApp.customer.menuTiposEvento">Menu Tipos Evento</Translate>
            </span>
          </dt>
          <dd>{customerEntity.menuTiposEvento}</dd>
          <dt>
            <span id="menuPlantillasPrecios">
              <Translate contentKey="customerTestApp.customer.menuPlantillasPrecios">Menu Plantillas Precios</Translate>
            </span>
          </dt>
          <dd>{customerEntity.menuPlantillasPrecios}</dd>
          <dt>
            <span id="menuPlantillasReserva">
              <Translate contentKey="customerTestApp.customer.menuPlantillasReserva">Menu Plantillas Reserva</Translate>
            </span>
          </dt>
          <dd>{customerEntity.menuPlantillasReserva}</dd>
          <dt>
            <span id="menuTarifas">
              <Translate contentKey="customerTestApp.customer.menuTarifas">Menu Tarifas</Translate>
            </span>
          </dt>
          <dd>{customerEntity.menuTarifas}</dd>
          <dt>
            <span id="menuComprasReservas">
              <Translate contentKey="customerTestApp.customer.menuComprasReservas">Menu Compras Reservas</Translate>
            </span>
          </dt>
          <dd>{customerEntity.menuComprasReservas}</dd>
          <dt>
            <span id="menuInformes">
              <Translate contentKey="customerTestApp.customer.menuInformes">Menu Informes</Translate>
            </span>
          </dt>
          <dd>{customerEntity.menuInformes}</dd>
          <dt>
            <span id="menuInformesSesion">
              <Translate contentKey="customerTestApp.customer.menuInformesSesion">Menu Informes Sesion</Translate>
            </span>
          </dt>
          <dd>{customerEntity.menuInformesSesion}</dd>
          <dt>
            <span id="thirdParty">
              <Translate contentKey="customerTestApp.customer.thirdParty">Third Party</Translate>
            </span>
          </dt>
          <dd>{customerEntity.thirdParty}</dd>
          <dt>
            <span id="menuAforoPorDias">
              <Translate contentKey="customerTestApp.customer.menuAforoPorDias">Menu Aforo Por Dias</Translate>
            </span>
          </dt>
          <dd>{customerEntity.menuAforoPorDias}</dd>
          <dt>
            <span id="status">
              <Translate contentKey="customerTestApp.customer.status">Status</Translate>
            </span>
          </dt>
          <dd>{customerEntity.status}</dd>
        </dl>
        <Button tag={Link} to="/customer" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/customer/${customerEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default CustomerDetail;
