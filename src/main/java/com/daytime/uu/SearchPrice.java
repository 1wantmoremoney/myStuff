package com.daytime.uu;

import com.alibaba.excel.EasyExcel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Description:
 * Author: Jiangchangpeng
 * Date: 2025/01/09/11:07
 */
public class SearchPrice {
    public static List<String> SEARCH_LIST = List.of(
            "爪子刀（渐变大理石）",
            "爪子刀（多普勒）",
            "爪子刀（伽马多普勒）",
            "爪子刀（渐变之色）",
            "爪子刀（表面淬火）",
            "爪子刀（虎牙）",
            "爪子刀（自动化）",
            "爪子刀（屠夫）",
            "爪子刀（传说）",
            "爪子刀（深红之网）",
            "爪子刀（★）",
            "爪子刀（自由之手）",
            "爪子刀（致命紫罗兰）",
            "爪子刀（澄澈之水）",
            "爪子刀（大马士革钢）",
            "爪子刀（黑色层压板）",
            "爪子刀（蓝钢）",
            "爪子刀（人工染色）",
            "爪子刀（噩梦之夜）",
            "爪子刀（枯焦之色）",
            "爪子刀（都市伪装）",
            "爪子刀（北方森林）",
            "爪子刀（外表生锈）",
            "蝴蝶刀（伽马多普勒）",
            "蝴蝶刀（多普勒）",
            "蝴蝶刀（渐变之色）",
            "蝴蝶刀（传说）",
            "蝴蝶刀（渐变大理石）",
            "蝴蝶刀（虎牙）",
            "蝴蝶刀（表面淬火）",
            "蝴蝶刀（深红之网）",
            "蝴蝶刀（屠夫）",
            "蝴蝶刀（自动化）",
            "蝴蝶刀（★）",
            "蝴蝶刀（紫罗兰）",
            "蝴蝶刀（自由之手）",
            "蝴蝶刀（蓝钢）",
            "蝴蝶刀（大马士革钢）",
            "蝴蝶刀（黑色层压板）",
            "蝴蝶刀（噩梦之夜）",
            "蝴蝶刀（澄澈之水）",
            "蝴蝶刀（人工染色）",
            "蝴蝶刀（北方森林）",
            "蝴蝶刀（都市伪装）",
            "蝴蝶刀（枯焦之色）",
            "蝴蝶刀（外表生锈）",
            "M9（自由之手） ",
            "M9（黑色层压板）",
            "M9（蓝钢）",
            "M9（噩梦之夜）",
            "M9（致命紫罗兰）",
            "M9（外表生锈）",
            "M9（虎牙） ",
            "M9（深红之网）",
            "M9（自动化）",
            "M9（屠夫）",
            "M9（★）",
            "M9（传说）",
            "M9（渐变大理石）",
            "M9（多普勒） ",
            "M9（伽马多普勒）"
    );


    public static void main(String[] args) {
        try {
            List<SearchResult> results = new ArrayList<>();

            for (String word : SEARCH_LIST) {
                doSearch(results, word);
            }
            results = results.stream().distinct().toList();
            String fileName = "/Users/levine/Documents/cs2" + "价目表" + System.currentTimeMillis() + ".xlsx";
            EasyExcel.write(fileName, SearchResult.class).sheet().doWrite(results);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static void doSearch(List<SearchResult> results, String keyWord) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        String jsonRequestBody = """
                {
                    "filterMap": {},
                    "gameId": 730,
                    "keyWords": "%s",
                    "listSortType": 0,
                    "listType": 10,
                    "pageIndex": 1,
                    "pageSize": 500,
                    "propertyFilterTags": [],
                    "sortType": 0,
                    "stickerAbrade": 0,
                    "stickersIsSort": false,
                    "Sessionid": "ZsGDxO8eolADAGkrQ/t9B8C1"
                }
                """.formatted(keyWord);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.youpin898.com/api/homepage/search/new/list"))
                .header("br_interactive_uuid", "81d47653-fcc5-4e08-ae79-86909e7b2d6d")
                .header("DeviceToken", "ZsGDxO8eolADAGkrQ/t9B8C1")
                .header("DeviceId", "ZsGDxO8eolADAGkrQ/t9B8C1")
                .header("requestTag", "484ABC09F9A8F813E25C8ED697421EAF")
                .header("deviceType", "1")
                .header("platform", "android")
                .header("currentTheme", "Light")
                .header("package-type", "uuyp")
                .header("App-Version", "5.27.5")
                .header("uk", "5Ck5Q5zXNukEkS2jAPqyb2qR6LvnoN8Kf6I0IJfy1AzVTFyS9GUV0e2P9SJcUMn1H")
                .header("Device-Info", "{\"deviceId\":\"ZsGDxO8eolADAGkrQ/t9B8C1\",\"deviceType\":\"23127PN0CC\",\"hasSteamApp\":1,\"requestTag\":\"484ABC09F9A8F813E25C8ED697421EAF\",\"systemName \":\"Android\",\"systemVersion\":\"15\"}")
                .header("AppType", "4")
                .header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxNTRiNjNlNTMzOGY0OTFlOGE3ZDYxODMwOWU5ZjVkMSIsIm5hbWVpZCI6Ijc2NTMyIiwiSWQiOiI3NjUzMiIsInVuaXF1ZV9uYW1lIjoiWVAwMDAwMDc2NTMyIiwiTmFtZSI6IllQMDAwMDA3NjUzMiIsInZlcnNpb24iOiJZdlUiLCJuYmYiOjE3MzYxNTk2NDcsImV4cCI6MTczODg3MDQ0NywiaXNzIjoieW91cGluODk4LmNvbSIsImRldmljZUlkIjoiWnNHRHhPOGVvbEFEQUdrclEvdDlCOEMxIiwiYXVkIjoidXNlciJ9.ziMdm9mWzf0olx93W7GcQi72Y2FK7FfRK_66vD3F3sQ")
                .header("Content-Type", "application/json; charset=utf-8")
                .header("User-Agent", "okhttp/3.14.9")
                .header("Cookie", "acw_tc=0bdd26c217363907666587571e84e6fa3ae3b14095695aba2d614ec5114fac")
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequestBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper objectMapper = new ObjectMapper();
        List<PriceDto> commodities = objectMapper.readValue(
                objectMapper.readTree(response.body())
                        .path("Data")
                        .path("commodityTemplateList")
                        .toString(),
                new TypeReference<List<PriceDto>>() {
                }
        );
        filterItem(results, commodities, keyWord);
    }


    private static void filterItem(List<SearchResult> results, List<PriceDto> commodities, String keyWord) {

        PriceDto NewpriceDto = commodities.stream()
                .filter(dto -> !dto.getCommodityName().contains("StatTrak") && dto.getExterior().equals("崭新出厂") )
                .sorted(Comparator.comparing(PriceDto::getPrice))
                .findFirst()
                .orElse(null);
        PriceDto SecondNewpriceDto = commodities.stream()
                .filter(dto -> !dto.getCommodityName().contains("StatTrak") && dto.getExterior().equals("略有磨损"))
                .sorted(Comparator.comparing(PriceDto::getPrice))
                .findFirst()
                .orElse(null);
        PriceDto LongTimepriceDto = commodities.stream()
                .filter(dto -> !dto.getCommodityName().contains("StatTrak") && dto.getExterior().equals("久经沙场"))
                .sorted(Comparator.comparing(PriceDto::getPrice))
                .findFirst()
                .orElse(null);
        PriceDto WarSignpriceDto = commodities.stream()
                .filter(dto -> !dto.getCommodityName().contains("StatTrak") && dto.getExterior().equals("战痕累累"))
                .sorted(Comparator.comparing(PriceDto::getPrice))
                .findFirst()
                .orElse(null);
        PriceDto BrokenpriceDto = commodities.stream()
                .filter(dto -> !dto.getCommodityName().contains("StatTrak") && dto.getExterior().equals("破损不堪"))
                .sorted(Comparator.comparing(PriceDto::getPrice))
                .findFirst()
                .orElse(null);
        if (NewpriceDto != null) {
            SearchResult searchResult = new SearchResult();
            searchResult.setPrice(NewpriceDto.getPrice());
            searchResult.setCommodityName(NewpriceDto.getCommodityName());
            searchResult.setExterior(NewpriceDto.getExterior());
            results.add(searchResult);
        } else {
            if (!keyWord.contains("生锈")) {
                SearchResult searchResult = new SearchResult();
                searchResult.setPrice(null);
                searchResult.setCommodityName(keyWord + "(崭新出厂)");
                searchResult.setExterior("崭新出厂");
                results.add(searchResult);
            }
        }

        if (SecondNewpriceDto != null) {
            SearchResult searchResult = new SearchResult();
            searchResult.setPrice(SecondNewpriceDto.getPrice());
            searchResult.setCommodityName(SecondNewpriceDto.getCommodityName());
            searchResult.setExterior(SecondNewpriceDto.getExterior());
            results.add(searchResult);
        } else {
            if (!keyWord.contains("生锈")) {
                SearchResult searchResult = new SearchResult();
                searchResult.setPrice(null);
                searchResult.setCommodityName(keyWord + "(略有磨损)");
                searchResult.setExterior("略有磨损");
                results.add(searchResult);
            }
        }

        if (LongTimepriceDto != null) {
            SearchResult searchResult = new SearchResult();
            searchResult.setPrice(LongTimepriceDto.getPrice());
            searchResult.setCommodityName(LongTimepriceDto.getCommodityName());
            searchResult.setExterior(LongTimepriceDto.getExterior());
            results.add(searchResult);
        } else {
            if (!keyWord.contains("渐变") && !keyWord.contains("多普勒") && !keyWord.contains("虎牙") && !keyWord.contains("生锈")) {
                SearchResult searchResult = new SearchResult();
                searchResult.setPrice(null);
                searchResult.setCommodityName(keyWord + "(久经沙场)");
                searchResult.setExterior("久经沙场");
                results.add(searchResult);
            }
        }

        if (WarSignpriceDto != null) {
            SearchResult searchResult = new SearchResult();
            searchResult.setPrice(WarSignpriceDto.getPrice());
            searchResult.setCommodityName(WarSignpriceDto.getCommodityName());
            searchResult.setExterior(WarSignpriceDto.getExterior());
            results.add(searchResult);
        } else {
            if (!keyWord.contains("渐变") && !keyWord.contains("多普勒") && !keyWord.contains("虎牙") && !keyWord.contains("屠夫")) {
                SearchResult searchResult = new SearchResult();
                searchResult.setPrice(null);
                searchResult.setCommodityName(keyWord + "(战痕累累)");
                searchResult.setExterior("战痕累累");
                results.add(searchResult);
            }
        }

        if (BrokenpriceDto != null) {
            SearchResult searchResult = new SearchResult();
            searchResult.setPrice(BrokenpriceDto.getPrice());
            searchResult.setCommodityName(BrokenpriceDto.getCommodityName());
            searchResult.setExterior(BrokenpriceDto.getExterior());
            results.add(searchResult);
        } else {
            if (!keyWord.contains("渐变") && !keyWord.contains("多普勒") && !keyWord.contains("虎牙") && !keyWord.contains("屠夫")) {
                SearchResult searchResult = new SearchResult();
                searchResult.setPrice(null);
                searchResult.setCommodityName(keyWord + "(破损不堪)");
                searchResult.setExterior("破损不堪");
                results.add(searchResult);
            }
        }
    }
}
