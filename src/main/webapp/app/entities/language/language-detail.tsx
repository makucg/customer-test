import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './language.reducer';

export const LanguageDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const languageEntity = useAppSelector(state => state.language.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="languageDetailsHeading">
          <Translate contentKey="customerTestApp.language.detail.title">Language</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="global.field.id">ID</Translate>
            </span>
          </dt>
          <dd>{languageEntity.id}</dd>
          <dt>
            <span id="languageName">
              <Translate contentKey="customerTestApp.language.languageName">Language Name</Translate>
            </span>
          </dt>
          <dd>{languageEntity.languageName}</dd>
          <dt>
            <span id="languageCode">
              <Translate contentKey="customerTestApp.language.languageCode">Language Code</Translate>
            </span>
          </dt>
          <dd>{languageEntity.languageCode}</dd>
          <dt>
            <Translate contentKey="customerTestApp.language.customer">Customer</Translate>
          </dt>
          <dd>{languageEntity.customer ? languageEntity.customer.id : ''}</dd>
        </dl>
        <Button tag={Link} to="/language" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/language/${languageEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default LanguageDetail;
