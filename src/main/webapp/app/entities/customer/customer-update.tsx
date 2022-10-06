import React, { useState, useEffect } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import { Button, Row, Col, FormText } from 'reactstrap';
import { isNumber, Translate, translate, ValidatedField, ValidatedForm } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { ICustomer } from 'app/shared/model/customer.model';
import { Status } from 'app/shared/model/enumerations/status.model';
import { getEntity, updateEntity, createEntity, reset } from './customer.reducer';

export const CustomerUpdate = () => {
  const dispatch = useAppDispatch();

  const navigate = useNavigate();

  const { id } = useParams<'id'>();
  const isNew = id === undefined;

  const customerEntity = useAppSelector(state => state.customer.entity);
  const loading = useAppSelector(state => state.customer.loading);
  const updating = useAppSelector(state => state.customer.updating);
  const updateSuccess = useAppSelector(state => state.customer.updateSuccess);
  const statusValues = Object.keys(Status);

  const handleClose = () => {
    navigate('/customer' + location.search);
  };

  useEffect(() => {
    if (isNew) {
      dispatch(reset());
    } else {
      dispatch(getEntity(id));
    }
  }, []);

  useEffect(() => {
    if (updateSuccess) {
      handleClose();
    }
  }, [updateSuccess]);

  const saveEntity = values => {
    const entity = {
      ...customerEntity,
      ...values,
    };

    if (isNew) {
      dispatch(createEntity(entity));
    } else {
      dispatch(updateEntity(entity));
    }
  };

  const defaultValues = () =>
    isNew
      ? {}
      : {
          status: 'CREATED',
          ...customerEntity,
        };

  return (
    <div>
      <Row className="justify-content-center">
        <Col md="8">
          <h2 id="customerTestApp.customer.home.createOrEditLabel" data-cy="CustomerCreateUpdateHeading">
            <Translate contentKey="customerTestApp.customer.home.createOrEditLabel">Create or edit a Customer</Translate>
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <ValidatedForm defaultValues={defaultValues()} onSubmit={saveEntity}>
              {!isNew ? (
                <ValidatedField
                  name="id"
                  required
                  readOnly
                  id="customer-id"
                  label={translate('global.field.id')}
                  validate={{ required: true }}
                />
              ) : null}
              <ValidatedField
                label={translate('customerTestApp.customer.name')}
                id="customer-name"
                name="name"
                data-cy="name"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('customerTestApp.customer.lastName')}
                id="customer-lastName"
                name="lastName"
                data-cy="lastName"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('customerTestApp.customer.cif')}
                id="customer-cif"
                name="cif"
                data-cy="cif"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('customerTestApp.customer.direction')}
                id="customer-direction"
                name="direction"
                data-cy="direction"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('customerTestApp.customer.municipality')}
                id="customer-municipality"
                name="municipality"
                data-cy="municipality"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('customerTestApp.customer.pc')}
                id="customer-pc"
                name="pc"
                data-cy="pc"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('customerTestApp.customer.telephoneNumber')}
                id="customer-telephoneNumber"
                name="telephoneNumber"
                data-cy="telephoneNumber"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('customerTestApp.customer.email')}
                id="customer-email"
                name="email"
                data-cy="email"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('customerTestApp.customer.privacyUrl')}
                id="customer-privacyUrl"
                name="privacyUrl"
                data-cy="privacyUrl"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('customerTestApp.customer.cancelUrl')}
                id="customer-cancelUrl"
                name="cancelUrl"
                data-cy="cancelUrl"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('customerTestApp.customer.enterprise')}
                id="customer-enterprise"
                name="enterprise"
                data-cy="enterprise"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('customerTestApp.customer.registryCode')}
                id="customer-registryCode"
                name="registryCode"
                data-cy="registryCode"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('customerTestApp.customer.mainRoomName')}
                id="customer-mainRoomName"
                name="mainRoomName"
                data-cy="mainRoomName"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('customerTestApp.customer.subdomain')}
                id="customer-subdomain"
                name="subdomain"
                data-cy="subdomain"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('customerTestApp.customer.menuTpv')}
                id="customer-menuTpv"
                name="menuTpv"
                data-cy="menuTpv"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('customerTestApp.customer.menuClientes')}
                id="customer-menuClientes"
                name="menuClientes"
                data-cy="menuClientes"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('customerTestApp.customer.menuIntegraciones')}
                id="customer-menuIntegraciones"
                name="menuIntegraciones"
                data-cy="menuIntegraciones"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('customerTestApp.customer.menuSalas')}
                id="customer-menuSalas"
                name="menuSalas"
                data-cy="menuSalas"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('customerTestApp.customer.menuPerfil')}
                id="customer-menuPerfil"
                name="menuPerfil"
                data-cy="menuPerfil"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('customerTestApp.customer.menuAyuda')}
                id="customer-menuAyuda"
                name="menuAyuda"
                data-cy="menuAyuda"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('customerTestApp.customer.menuTaquilla')}
                id="customer-menuTaquilla"
                name="menuTaquilla"
                data-cy="menuTaquilla"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('customerTestApp.customer.menuAbonos')}
                id="customer-menuAbonos"
                name="menuAbonos"
                data-cy="menuAbonos"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('customerTestApp.customer.menuICAA')}
                id="customer-menuICAA"
                name="menuICAA"
                data-cy="menuICAA"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('customerTestApp.customer.disclaimers')}
                id="customer-disclaimers"
                name="disclaimers"
                data-cy="disclaimers"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('customerTestApp.customer.reglas')}
                id="customer-reglas"
                name="reglas"
                data-cy="reglas"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('customerTestApp.customer.usuarios')}
                id="customer-usuarios"
                name="usuarios"
                data-cy="usuarios"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('customerTestApp.customer.cupones')}
                id="customer-cupones"
                name="cupones"
                data-cy="cupones"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('customerTestApp.customer.ventaCruzada')}
                id="customer-ventaCruzada"
                name="ventaCruzada"
                data-cy="ventaCruzada"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('customerTestApp.customer.packs')}
                id="customer-packs"
                name="packs"
                data-cy="packs"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('customerTestApp.customer.menuTiposEvento')}
                id="customer-menuTiposEvento"
                name="menuTiposEvento"
                data-cy="menuTiposEvento"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('customerTestApp.customer.menuPlantillasPrecios')}
                id="customer-menuPlantillasPrecios"
                name="menuPlantillasPrecios"
                data-cy="menuPlantillasPrecios"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('customerTestApp.customer.menuPlantillasReserva')}
                id="customer-menuPlantillasReserva"
                name="menuPlantillasReserva"
                data-cy="menuPlantillasReserva"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('customerTestApp.customer.menuTarifas')}
                id="customer-menuTarifas"
                name="menuTarifas"
                data-cy="menuTarifas"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('customerTestApp.customer.menuComprasReservas')}
                id="customer-menuComprasReservas"
                name="menuComprasReservas"
                data-cy="menuComprasReservas"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('customerTestApp.customer.menuInformes')}
                id="customer-menuInformes"
                name="menuInformes"
                data-cy="menuInformes"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('customerTestApp.customer.menuInformesSesion')}
                id="customer-menuInformesSesion"
                name="menuInformesSesion"
                data-cy="menuInformesSesion"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('customerTestApp.customer.thirdParty')}
                id="customer-thirdParty"
                name="thirdParty"
                data-cy="thirdParty"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('customerTestApp.customer.menuAforoPorDias')}
                id="customer-menuAforoPorDias"
                name="menuAforoPorDias"
                data-cy="menuAforoPorDias"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('customerTestApp.customer.status')}
                id="customer-status"
                name="status"
                data-cy="status"
                type="select"
              >
                {statusValues.map(status => (
                  <option value={status} key={status}>
                    {translate('customerTestApp.Status.' + status)}
                  </option>
                ))}
              </ValidatedField>
              <Button tag={Link} id="cancel-save" data-cy="entityCreateCancelButton" to="/customer" replace color="info">
                <FontAwesomeIcon icon="arrow-left" />
                &nbsp;
                <span className="d-none d-md-inline">
                  <Translate contentKey="entity.action.back">Back</Translate>
                </span>
              </Button>
              &nbsp;
              <Button color="primary" id="save-entity" data-cy="entityCreateSaveButton" type="submit" disabled={updating}>
                <FontAwesomeIcon icon="save" />
                &nbsp;
                <Translate contentKey="entity.action.save">Save</Translate>
              </Button>
            </ValidatedForm>
          )}
        </Col>
      </Row>
    </div>
  );
};

export default CustomerUpdate;
