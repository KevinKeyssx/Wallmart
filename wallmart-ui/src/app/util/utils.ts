import { IMap } from "../interface/http.interface";

export class Utils {
    static createNewObject(request: IMap[]): {} | undefined{
        if (!request) {
            return undefined;
        }

        return request.reduce((accumulator, currentValue) => {
            return { ...accumulator, [currentValue.key]: currentValue.value};
        }, {});
    }
}