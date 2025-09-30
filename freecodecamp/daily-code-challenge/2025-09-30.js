/*

Phone Number Formatter

Given a string of ten digits, return the string as a phone number in this format: "+D (DDD) DDD-DDDD".

Tests
Passed:1. formatNumber("05552340182") should return "+0 (555) 234-0182".
Passed:2. formatNumber("15554354792") should return "+1 (555) 435-4792".

*/

function formatNumber(phone) {
    return `+${phone[0]} (${phone.slice(1, 4)}) ${phone.slice(4, 7)}-${phone.slice(7)}`;
}
