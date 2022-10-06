import { ILanguage } from 'app/shared/model/language.model';
import { Status } from 'app/shared/model/enumerations/status.model';

export interface ICustomer {
  id?: number;
  name?: string;
  lastName?: string;
  cif?: string;
  direction?: string;
  municipality?: string;
  pc?: string;
  telephoneNumber?: string;
  email?: string;
  privacyUrl?: string;
  cancelUrl?: string;
  enterprise?: string;
  registryCode?: string;
  mainRoomName?: string;
  subdomain?: string;
  menuTpv?: string;
  menuClientes?: string;
  menuIntegraciones?: string;
  menuSalas?: string;
  menuPerfil?: string;
  menuAyuda?: string;
  menuTaquilla?: string;
  menuAbonos?: string;
  menuICAA?: string;
  disclaimers?: string;
  reglas?: string;
  usuarios?: string;
  cupones?: string;
  ventaCruzada?: string;
  packs?: string;
  menuTiposEvento?: string;
  menuPlantillasPrecios?: string;
  menuPlantillasReserva?: string;
  menuTarifas?: string;
  menuComprasReservas?: string;
  menuInformes?: string;
  menuInformesSesion?: string;
  thirdParty?: string;
  menuAforoPorDias?: string;
  status?: Status;
  languages?: ILanguage[] | null;
}

export const defaultValue: Readonly<ICustomer> = {};
