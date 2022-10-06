import { ICustomer } from 'app/shared/model/customer.model';

export interface ILanguage {
  id?: number;
  languageName?: string;
  languageCode?: string;
  customer?: ICustomer | null;
}

export const defaultValue: Readonly<ILanguage> = {};
