import { Tarjeta } from './tarjeta.interface';

export interface Cliente {
    id: Int16Array,
    nombre: string,
    direccion: string,
    ciudad: string,
    telefono: string
    tarjetas: Tarjeta[]
}