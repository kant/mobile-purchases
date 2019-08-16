export function msToFormattedString(ms: string): string {
    return new Date(Number.parseInt(ms)).toISOString()
}

export function optionalMsToFormattedString(ms?: string): string | undefined {
    if (ms) {
        return msToFormattedString(ms);
    } else {
        return undefined;
    }
}

export function thirtyMonths(from: Date = new Date()): Date {
    console.log(`from: ${from.getTime()}`);
    const newDate = new Date(from.getTime());
    console.log(`newDate: ${newDate.getTime()}`);
    newDate.setUTCMonth(from.getMonth() + 30);
    console.log(`newDate+30: ${newDate.getTime()}`);
    console.log(`newDate offset: ${newDate.getUTCDate()}`);
    return newDate;
}

export function dateToSecondTimestamp(date: Date): number {
    return Math.ceil(date.getTime() / 1000);
}