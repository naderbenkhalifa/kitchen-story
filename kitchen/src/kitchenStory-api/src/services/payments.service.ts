/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';

import { Payment } from '../models/payment';
@Injectable({
  providedIn: 'root',
})
class PaymentsService extends __BaseService {
  static readonly savePath = '/kitchenstory/v1/payments/create';

  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * Enregistrer un paiement
   *
   * Cette methode permet d'enregistrer un paiement
   * @param body undefined
   * @return L'objet paiement crée
   */
  saveResponse(body?: Payment): __Observable<__StrictHttpResponse<Payment>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = body;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/kitchenstory/v1/payments/create`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Payment>;
      })
    );
  }
  /**
   * Enregistrer un paiement
   *
   * Cette methode permet d'enregistrer un paiement
   * @param body undefined
   * @return L'objet paiement crée
   */
  save(body?: Payment): __Observable<Payment> {
    return this.saveResponse(body).pipe(
      __map(_r => _r.body as Payment)
    );
  }
}

module PaymentsService {
}

export { PaymentsService }
