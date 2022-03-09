import { IProduct } from "./product.interface";

export interface IRequest {
    url         : string;
    verb        : string;
    params?     : IMap[];
}

export interface IMap {
    key         : string;
    value       : any;
}

export interface IPage {
    content             : IProduct[];
    pageable            : string;
    totalPages          : number;
    totalElements       : number;
    last                : boolean;
    first               : boolean;
    size                : number;
    number              : number;
    sort                : ISort;
    numberOfElements    : number;
    empty               : boolean;
}

export interface ISort {
    sorted              : boolean;
    unsorted            : boolean;
    empty               : boolean;
}

export interface IPageable {
    page                : number;
    size                : number;
    order               : string
    asc                 : boolean;
    length              : number
}