import React, { useState, useEffect } from 'react';
import { Link, useLocation, useNavigate } from 'react-router-dom';
import { Button, Table } from 'reactstrap';
import { Translate, getSortState, JhiPagination, JhiItemCount } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { ASC, DESC, ITEMS_PER_PAGE, SORT } from 'app/shared/util/pagination.constants';
import { overridePaginationStateWithQueryParams } from 'app/shared/util/entity-utils';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { ICustomer } from 'app/shared/model/customer.model';
import { getEntities } from './customer.reducer';

export const Customer = () => {
  const dispatch = useAppDispatch();

  const location = useLocation();
  const navigate = useNavigate();

  const [paginationState, setPaginationState] = useState(
    overridePaginationStateWithQueryParams(getSortState(location, ITEMS_PER_PAGE, 'id'), location.search)
  );

  const customerList = useAppSelector(state => state.customer.entities);
  const loading = useAppSelector(state => state.customer.loading);
  const totalItems = useAppSelector(state => state.customer.totalItems);

  const getAllEntities = () => {
    dispatch(
      getEntities({
        page: paginationState.activePage - 1,
        size: paginationState.itemsPerPage,
        sort: `${paginationState.sort},${paginationState.order}`,
      })
    );
  };

  const sortEntities = () => {
    getAllEntities();
    const endURL = `?page=${paginationState.activePage}&sort=${paginationState.sort},${paginationState.order}`;
    if (location.search !== endURL) {
      navigate(`${location.pathname}${endURL}`);
    }
  };

  useEffect(() => {
    sortEntities();
  }, [paginationState.activePage, paginationState.order, paginationState.sort]);

  useEffect(() => {
    const params = new URLSearchParams(location.search);
    const page = params.get('page');
    const sort = params.get(SORT);
    if (page && sort) {
      const sortSplit = sort.split(',');
      setPaginationState({
        ...paginationState,
        activePage: +page,
        sort: sortSplit[0],
        order: sortSplit[1],
      });
    }
  }, [location.search]);

  const sort = p => () => {
    setPaginationState({
      ...paginationState,
      order: paginationState.order === ASC ? DESC : ASC,
      sort: p,
    });
  };

  const handlePagination = currentPage =>
    setPaginationState({
      ...paginationState,
      activePage: currentPage,
    });

  const handleSyncList = () => {
    sortEntities();
  };

  return (
    <div>
      <h2 id="customer-heading" data-cy="CustomerHeading">
        <Translate contentKey="customerTestApp.customer.home.title">Customers</Translate>
        <div className="d-flex justify-content-end">
          <Button className="me-2" color="info" onClick={handleSyncList} disabled={loading}>
            <FontAwesomeIcon icon="sync" spin={loading} />{' '}
            <Translate contentKey="customerTestApp.customer.home.refreshListLabel">Refresh List</Translate>
          </Button>
          <Link to="/customer/new" className="btn btn-primary jh-create-entity" id="jh-create-entity" data-cy="entityCreateButton">
            <FontAwesomeIcon icon="plus" />
            &nbsp;
            <Translate contentKey="customerTestApp.customer.home.createLabel">Create new Customer</Translate>
          </Link>
        </div>
      </h2>
      <div className="table-responsive">
        {customerList && customerList.length > 0 ? (
          <Table responsive>
            <thead>
              <tr>
                <th className="hand" onClick={sort('id')}>
                  <Translate contentKey="customerTestApp.customer.id">ID</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('name')}>
                  <Translate contentKey="customerTestApp.customer.name">Name</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('lastName')}>
                  <Translate contentKey="customerTestApp.customer.lastName">Last Name</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('cif')}>
                  <Translate contentKey="customerTestApp.customer.cif">Cif</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('direction')}>
                  <Translate contentKey="customerTestApp.customer.direction">Direction</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('municipality')}>
                  <Translate contentKey="customerTestApp.customer.municipality">Municipality</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('pc')}>
                  <Translate contentKey="customerTestApp.customer.pc">Pc</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('telephoneNumber')}>
                  <Translate contentKey="customerTestApp.customer.telephoneNumber">Telephone Number</Translate>{' '}
                  <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('email')}>
                  <Translate contentKey="customerTestApp.customer.email">Email</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('privacyUrl')}>
                  <Translate contentKey="customerTestApp.customer.privacyUrl">Privacy Url</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('cancelUrl')}>
                  <Translate contentKey="customerTestApp.customer.cancelUrl">Cancel Url</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('enterprise')}>
                  <Translate contentKey="customerTestApp.customer.enterprise">Enterprise</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('registryCode')}>
                  <Translate contentKey="customerTestApp.customer.registryCode">Registry Code</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('mainRoomName')}>
                  <Translate contentKey="customerTestApp.customer.mainRoomName">Main Room Name</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('subdomain')}>
                  <Translate contentKey="customerTestApp.customer.subdomain">Subdomain</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('menuTpv')}>
                  <Translate contentKey="customerTestApp.customer.menuTpv">Menu Tpv</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('menuClientes')}>
                  <Translate contentKey="customerTestApp.customer.menuClientes">Menu Clientes</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('menuIntegraciones')}>
                  <Translate contentKey="customerTestApp.customer.menuIntegraciones">Menu Integraciones</Translate>{' '}
                  <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('menuSalas')}>
                  <Translate contentKey="customerTestApp.customer.menuSalas">Menu Salas</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('menuPerfil')}>
                  <Translate contentKey="customerTestApp.customer.menuPerfil">Menu Perfil</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('menuAyuda')}>
                  <Translate contentKey="customerTestApp.customer.menuAyuda">Menu Ayuda</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('menuTaquilla')}>
                  <Translate contentKey="customerTestApp.customer.menuTaquilla">Menu Taquilla</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('menuAbonos')}>
                  <Translate contentKey="customerTestApp.customer.menuAbonos">Menu Abonos</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('menuICAA')}>
                  <Translate contentKey="customerTestApp.customer.menuICAA">Menu ICAA</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('disclaimers')}>
                  <Translate contentKey="customerTestApp.customer.disclaimers">Disclaimers</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('reglas')}>
                  <Translate contentKey="customerTestApp.customer.reglas">Reglas</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('usuarios')}>
                  <Translate contentKey="customerTestApp.customer.usuarios">Usuarios</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('cupones')}>
                  <Translate contentKey="customerTestApp.customer.cupones">Cupones</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('ventaCruzada')}>
                  <Translate contentKey="customerTestApp.customer.ventaCruzada">Venta Cruzada</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('packs')}>
                  <Translate contentKey="customerTestApp.customer.packs">Packs</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('menuTiposEvento')}>
                  <Translate contentKey="customerTestApp.customer.menuTiposEvento">Menu Tipos Evento</Translate>{' '}
                  <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('menuPlantillasPrecios')}>
                  <Translate contentKey="customerTestApp.customer.menuPlantillasPrecios">Menu Plantillas Precios</Translate>{' '}
                  <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('menuPlantillasReserva')}>
                  <Translate contentKey="customerTestApp.customer.menuPlantillasReserva">Menu Plantillas Reserva</Translate>{' '}
                  <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('menuTarifas')}>
                  <Translate contentKey="customerTestApp.customer.menuTarifas">Menu Tarifas</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('menuComprasReservas')}>
                  <Translate contentKey="customerTestApp.customer.menuComprasReservas">Menu Compras Reservas</Translate>{' '}
                  <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('menuInformes')}>
                  <Translate contentKey="customerTestApp.customer.menuInformes">Menu Informes</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('menuInformesSesion')}>
                  <Translate contentKey="customerTestApp.customer.menuInformesSesion">Menu Informes Sesion</Translate>{' '}
                  <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('thirdParty')}>
                  <Translate contentKey="customerTestApp.customer.thirdParty">Third Party</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('menuAforoPorDias')}>
                  <Translate contentKey="customerTestApp.customer.menuAforoPorDias">Menu Aforo Por Dias</Translate>{' '}
                  <FontAwesomeIcon icon="sort" />
                </th>
                <th className="hand" onClick={sort('status')}>
                  <Translate contentKey="customerTestApp.customer.status">Status</Translate> <FontAwesomeIcon icon="sort" />
                </th>
                <th />
              </tr>
            </thead>
            <tbody>
              {customerList.map((customer, i) => (
                <tr key={`entity-${i}`} data-cy="entityTable">
                  <td>
                    <Button tag={Link} to={`/customer/${customer.id}`} color="link" size="sm">
                      {customer.id}
                    </Button>
                  </td>
                  <td>{customer.name}</td>
                  <td>{customer.lastName}</td>
                  <td>{customer.cif}</td>
                  <td>{customer.direction}</td>
                  <td>{customer.municipality}</td>
                  <td>{customer.pc}</td>
                  <td>{customer.telephoneNumber}</td>
                  <td>{customer.email}</td>
                  <td>{customer.privacyUrl}</td>
                  <td>{customer.cancelUrl}</td>
                  <td>{customer.enterprise}</td>
                  <td>{customer.registryCode}</td>
                  <td>{customer.mainRoomName}</td>
                  <td>{customer.subdomain}</td>
                  <td>{customer.menuTpv}</td>
                  <td>{customer.menuClientes}</td>
                  <td>{customer.menuIntegraciones}</td>
                  <td>{customer.menuSalas}</td>
                  <td>{customer.menuPerfil}</td>
                  <td>{customer.menuAyuda}</td>
                  <td>{customer.menuTaquilla}</td>
                  <td>{customer.menuAbonos}</td>
                  <td>{customer.menuICAA}</td>
                  <td>{customer.disclaimers}</td>
                  <td>{customer.reglas}</td>
                  <td>{customer.usuarios}</td>
                  <td>{customer.cupones}</td>
                  <td>{customer.ventaCruzada}</td>
                  <td>{customer.packs}</td>
                  <td>{customer.menuTiposEvento}</td>
                  <td>{customer.menuPlantillasPrecios}</td>
                  <td>{customer.menuPlantillasReserva}</td>
                  <td>{customer.menuTarifas}</td>
                  <td>{customer.menuComprasReservas}</td>
                  <td>{customer.menuInformes}</td>
                  <td>{customer.menuInformesSesion}</td>
                  <td>{customer.thirdParty}</td>
                  <td>{customer.menuAforoPorDias}</td>
                  <td>
                    <Translate contentKey={`customerTestApp.Status.${customer.status}`} />
                  </td>
                  <td className="text-end">
                    <div className="btn-group flex-btn-group-container">
                      <Button tag={Link} to={`/customer/${customer.id}`} color="info" size="sm" data-cy="entityDetailsButton">
                        <FontAwesomeIcon icon="eye" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.view">View</Translate>
                        </span>
                      </Button>
                      <Button
                        tag={Link}
                        to={`/customer/${customer.id}/edit?page=${paginationState.activePage}&sort=${paginationState.sort},${paginationState.order}`}
                        color="primary"
                        size="sm"
                        data-cy="entityEditButton"
                      >
                        <FontAwesomeIcon icon="pencil-alt" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.edit">Edit</Translate>
                        </span>
                      </Button>
                      <Button
                        tag={Link}
                        to={`/customer/${customer.id}/delete?page=${paginationState.activePage}&sort=${paginationState.sort},${paginationState.order}`}
                        color="danger"
                        size="sm"
                        data-cy="entityDeleteButton"
                      >
                        <FontAwesomeIcon icon="trash" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.delete">Delete</Translate>
                        </span>
                      </Button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </Table>
        ) : (
          !loading && (
            <div className="alert alert-warning">
              <Translate contentKey="customerTestApp.customer.home.notFound">No Customers found</Translate>
            </div>
          )
        )}
      </div>
      {totalItems ? (
        <div className={customerList && customerList.length > 0 ? '' : 'd-none'}>
          <div className="justify-content-center d-flex">
            <JhiItemCount page={paginationState.activePage} total={totalItems} itemsPerPage={paginationState.itemsPerPage} i18nEnabled />
          </div>
          <div className="justify-content-center d-flex">
            <JhiPagination
              activePage={paginationState.activePage}
              onSelect={handlePagination}
              maxButtons={5}
              itemsPerPage={paginationState.itemsPerPage}
              totalItems={totalItems}
            />
          </div>
        </div>
      ) : (
        ''
      )}
    </div>
  );
};

export default Customer;
