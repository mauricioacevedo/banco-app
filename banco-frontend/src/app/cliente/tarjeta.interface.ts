import { Asesor } from './asesor.interface';

export interface Tarjeta {
    id: Int16Array,
    numeroTarjeta: string,
    ccv: string,
    tipo: string,
    cliente: string,
    estadoTarjeta: string,
    fechaCreacion: string,
    fechaExpiracion: string,
    asesorBancario: Asesor
}